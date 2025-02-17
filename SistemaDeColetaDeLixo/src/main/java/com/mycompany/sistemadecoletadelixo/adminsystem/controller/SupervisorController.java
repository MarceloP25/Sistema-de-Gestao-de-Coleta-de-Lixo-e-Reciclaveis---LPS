/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Supervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.SupervisorDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateSupervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.SupervisorException;
import java.util.List;

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
            Long id,
            String nome,
            String dataNascimento,
            String cpf,
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
        Supervisor novoSupervisor = valid.validaCamposEntrada(
                nome, dataNascimento, cpf, email, cep, rua, bairro, cidade, numero, complemento,
                telefone, dataContrato, idDepartamento, estacaoDescarga, rotasSupervisionadas, veiculosSupervisionados);

        if (repositorio.find(id) == null) {
            repositorio.save(novoSupervisor);
        } else {
            throw new SupervisorException("Error - Já existe um supervisor com este 'ID'.");
        }
    }

    public void atualizarSupervisor(
            
            Long id,
            String nome,
            String dataNascimento,
            String cpf,
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
        Supervisor supervisorAtualizado = valid.validaCamposEntrada(
                 nome, dataNascimento, cpf, email, cep, rua, bairro, cidade, numero, complemento,
                telefone, dataContrato, idDepartamento, estacaoDescarga, rotasSupervisionadas, veiculosSupervisionados);

        supervisorAtualizado.setId(id);

        repositorio.update(supervisorAtualizado);
    }

    public Supervisor buscarSupervisor(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirSupervisor(Long id) {
        Supervisor supervisor = repositorio.find(id);
        if (supervisor != null) {
            repositorio.delete(id);
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
