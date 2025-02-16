/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.Admin;
import com.mycompany.sistemadecoletadelixo.adminsystem.factory.DatabaseJPA;
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
            String senha
            ) {

        ValidateAdministrador valid = new ValidateAdministrador();
        Administrador novoAdmin = valid.validaCamposEntrada(
                 nome, dataNascimento, cpf, email,senha, cep, rua, bairro, cidade, numero, complemento, telefone);

        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoAdmin);
        } else {
            throw new AdministradorException("Error - Já existe um administrador com este 'ID'.");
        }
    }

    public void atualizarAdmin(
            Long id,
            String nome,
            String dataNascimento,
            String cpfCnpj,
            String email,
            String senha,
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String telefone
            ) {

        ValidateAdministrador valid = new ValidateAdministrador();
        Administrador adminAtualizado = valid.validaCamposEntrada(
                 nome, dataNascimento, cpfCnpj, email,senha, cep, rua, bairro, cidade, numero, complemento, telefone);

        adminAtualizado.setId(id);

        repositorio.update(adminAtualizado);
    }

    public Administrador buscarAdmin(Long id) {
         this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Administrador admin = this.entityManager.find(Admin.class, id);

        this.entityManager.close();

        return admin;
    }

    public void excluirAdmin(Long id) {
        if (id != null) {
            repositorio.delete(id);
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
