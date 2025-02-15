/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.DepartamentoDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateDepartamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.DepartamentoException;
import com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel.TMDepartamento;
import javax.swing.JTable;
import java.util.List;


/**
 *
 * @author eduhe
 */
public class DepartamentoController {

    private DepartamentoDAO repositorio;
    private TMDepartamento TMDepartamento;

    public DepartamentoController() {
        repositorio = new DepartamentoDAO();
    }

    public void cadastrarDepartamento(
            long id,
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
        Departamento novoDepartamento = valid.validaCamposEntrada(nome, rua, bairro, cidade, numero, complemento, cep, numero, numero, numero, numero);

        if (repositorio.find(id) == null) {
            repositorio.save(novoDepartamento);
        } else {
            throw new DepartamentoException("Error - Já existe um departamento com este 'ID'.");
        }
    }

    public void atualizarDepartamento(
            String idOriginal,
            long id,
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
        Departamento departamentoAtualizado = valid.validaCamposEntrada(nome, rua, bairro, cidade, numero, complemento, cep, numero, numero, numero, numero);
        departamentoAtualizado.setId(idOriginal);

        repositorio.update(departamentoAtualizado);
    }

    public Departamento buscarDepartamento(long id) {
        return this.repositorio.find(id);
    }

    public void excluirDepartamento(long id) {
        Departamento departamento = repositorio.find(id);
        if (departamento != null) {
            repositorio.delete(departamento);
        } else {
            throw new DepartamentoException("Error - Departamento inexistente.");
        }
    }
     public void atualizarTMDepartamento(JTable grd) {
        List lst = repositorio.findAll();
        
        TMDepartamento tableModel = new TMDepartamento(lst);
        grd.setModel(tableModel);        
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
