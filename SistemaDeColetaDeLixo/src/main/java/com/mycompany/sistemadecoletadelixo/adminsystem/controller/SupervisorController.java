/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Supervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.SupervisorDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateSupervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.SupervisorException;

/**
 *
 * @author eduhe
 */
public class SupervisorController {

    private SupervisorDAO repositorio;

    public SupervisorController() {
        repositorio = new SupervisorDAO();
    }

    public void cadastrarSupervisor(
            String id,
            String nome,
            String dataNascimento,
            String cpfCnpj,
            String email,
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String telefone,
            String dataContrato,
            String idDepartamento,
            String estacaoDescarga,
            List<String> rotasSupervisionadas,
            List<String> veiculosSupervisionados) {

        ValidateSupervisor valid = new ValidateSupervisor();
        Supervisor novoSupervisor = valid.validacao(
                id, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento,
                telefone, dataContrato, idDepartamento, estacaoDescarga, rotasSupervisionadas, veiculosSupervisionados);

        if (repositorio.findById(id) == null) {
            repositorio.save(novoSupervisor);
        } else {
            throw new SupervisorException("Error - Já existe um supervisor com este 'ID'.");
        }
    }

    public void atualizarSupervisor(
            String idOriginal,
            String id,
            String nome,
            String dataNascimento,
            String cpfCnpj,
            String email,
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String telefone,
            String dataContrato,
            String idDepartamento,
            String estacaoDescarga,
            List<String> rotasSupervisionadas,
            List<String> veiculosSupervisionados) {

        ValidateSupervisor valid = new ValidateSupervisor();
        Supervisor supervisorAtualizado = valid.validacao(
                id, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento,
                telefone, dataContrato, idDepartamento, estacaoDescarga, rotasSupervisionadas, veiculosSupervisionados);

        supervisorAtualizado.setId(idOriginal);

        repositorio.update(supervisorAtualizado);
    }

    public Supervisor buscarSupervisor(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirSupervisor(String id) {
        Supervisor supervisor = repositorio.findById(id);
        if (supervisor != null) {
            repositorio.delete(supervisor);
        } else {
            throw new SupervisorException("Error - Supervisor inexistente.");
        }
    }

    public String imprimirListaSupervisores() {
        String listagemSupervisores = "";

        for (Object obj : this.repositorio.findAll()) {
            Supervisor supervisor = (Supervisor) obj;
            listagemSupervisores += supervisor.toString();
        }

        return listagemSupervisores;
    }
}
