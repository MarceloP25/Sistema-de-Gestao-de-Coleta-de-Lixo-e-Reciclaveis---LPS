/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Departamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.DepartamentoDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateDepartamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.DepartamentoException;

/**
 *
 * @author eduhe
 */
public class DepartamentoController {

    private DepartamentoDAO repositorio;

    public DepartamentoController() {
        repositorio = new DepartamentoDAO();
    }

    public void cadastrarDepartamento(
            String id,
            String nome,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String cep,
            int numEstacoesDescarga,
            int numOperadores,
            int numSupervisores,
            int numVeiculos) {

        ValidateDepartamento valid = new ValidateDepartamento();
        Departamento novoDepartamento = valid.validacao(
                id, nome, rua, bairro, cidade, numero, complemento, cep,
                numEstacoesDescarga, numOperadores, numSupervisores, numVeiculos
        );

        if (repositorio.findById(id) == null) {
            repositorio.save(novoDepartamento);
        } else {
            throw new DepartamentoException("Error - Já existe um departamento com este 'ID'.");
        }
    }

    public void atualizarDepartamento(
            String idOriginal,
            String id,
            String nome,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String cep,
            int numEstacoesDescarga,
            int numOperadores,
            int numSupervisores,
            int numVeiculos) {

        ValidateDepartamento valid = new ValidateDepartamento();
        Departamento departamentoAtualizado = valid.validacao(
                id, nome, rua, bairro, cidade, numero, complemento, cep,
                numEstacoesDescarga, numOperadores, numSupervisores, numVeiculos
        );
        departamentoAtualizado.setId(idOriginal);

        repositorio.update(departamentoAtualizado);
    }

    public Departamento buscarDepartamento(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirDepartamento(String id) {
        Departamento departamento = repositorio.findById(id);
        if (departamento != null) {
            repositorio.delete(departamento);
        } else {
            throw new DepartamentoException("Error - Departamento inexistente.");
        }
    }

    public String imprimirListaDepartamentos() {
        String listagemDepartamentos = "";

        for (Object obj : this.repositorio.findAll()) {
            Departamento departamento = (Departamento) obj;
            listagemDepartamentos += departamento.toString();
        }

        return listagemDepartamentos;
    }
}
