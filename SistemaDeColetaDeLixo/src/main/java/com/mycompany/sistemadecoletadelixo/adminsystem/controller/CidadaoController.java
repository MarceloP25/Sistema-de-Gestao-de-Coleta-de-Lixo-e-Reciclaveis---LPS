/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Cidadao;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.CidadaoDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateCidadao;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.CidadaoException;
/**
 *
 * @author eduhe
 */
public class CidadaoController {

    private CidadaoDAO repositorio;

    public CidadaoController() {
        repositorio = new CidadaoDAO();
    }

    public void cadastrarCidadao(
           long id,
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
            String telefone) {

        ValidateCidadao valid = new ValidateCidadao();
        Cidadao novoCidadao = valid.validacao(
                id, nome, dataNascimento, cpf, email, cep, rua, bairro, cidade, numero, complemento, telefone);

        if (repositorio.find(id) == null) {
            repositorio.save(novoCidadao);
        } else {
            throw new CidadaoException("Error - Já existe um cidadão com este 'ID'.");
        }
    }

    public void atualizarCidadao(
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
            String telefone) {
        
        long idLong = Long.parseLong(id); 
        long idOriginalLong = Long.parseLong(idOriginal);
        
        ValidateCidadao valid = new ValidateCidadao();
        Cidadao cidadaoAtualizado = valid.validacao(
                idLong, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento, telefone);

        cidadaoAtualizado.setId(idOriginalLong);

        repositorio.update(cidadaoAtualizado);
    }

    public Cidadao buscarCidadao(long id) {
        return this.repositorio.find(id);
    }

    public void excluirCidadao(long id) {
        Cidadao cidadao = repositorio.find(id);
        if (cidadao != null) {
            repositorio.delete(id);
        } else {
            throw new CidadaoException("Error - Cidadão inexistente.");
        }
    }

    public String imprimirListaCidadaos() {
        String listagemCidadaos = "";

        for (Object obj : this.repositorio.findAll()) {
            Cidadao cidadao = (Cidadao) obj;
            listagemCidadaos += cidadao.toString();
        }

        return listagemCidadaos;
    }
}
