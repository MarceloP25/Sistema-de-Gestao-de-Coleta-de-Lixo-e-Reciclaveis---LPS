/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Administrador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.AdministradorDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateAdministrador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.AdministradorException;

/**
 *
 * @author eduhe
 */
public class AdministradorController {

    private AdministradorDAO repositorio;

    public AdministradorController() {
        repositorio = new AdministradorDAO();
    }

    public void cadastrarAdmin(
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
            String idDepartamento) {

        ValidateAdministrador valid = new ValidateAdministrador();
        Administrador novoAdmin = valid.validaCamposEntrada(
                id, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento, telefone, idDepartamento);

        if (repositorio.findByName(nome) == null) {
            repositorio.save(novoAdmin);
        } else {
            throw new AdministradorException("Error - Já existe um administrador com este 'ID'.");
        }
    }

    public void atualizarAdmin(
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
            String idDepartamento) {

        ValidateAdministrador valid = new ValidateAdministrador();
        Administrador adminAtualizado = valid.validacao(
                id, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento, telefone, idDepartamento);

        adminAtualizado.setId(idOriginal);

        repositorio.update(adminAtualizado);
    }

    public Administrador buscarAdmin(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirAdmin(String id) {
        Administrador admin = repositorio.findById(id);
        if (admin != null) {
            repositorio.delete(admin);
        } else {
            throw new AdministradorException("Error - Administrador inexistente.");
        }
    }

    public String imprimirListaAdmins() {
        String listagemAdmins = "";

        for (Object obj : this.repositorio.findAll()) {
            Administrador admin = (Administrador) obj;
            listagemAdmins += admin.toString();
        }

        return listagemAdmins;
    }
}
