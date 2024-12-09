/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.PontoDeColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.PontoDeColetaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidatePontoDeColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.PontoDeColetaException;

/**
 *
 * @author eduhe
 */
public class PontosDeColetaController {

    private PontoDeColetaDAO repositorio;

    public PontosDeColetaController() {
        repositorio = new PontoDeColetaDAO();
    }

    public void cadastrarPontoColeta(
            String id,
            String localizacao,
            int numeroLixeiras,
            List<String> tiposLixeira) {

        ValidatePontoDeColeta valid = new ValidatePontoDeColeta();
        PontoDeColeta novoPontoColeta = valid.validacao(id, localizacao, numeroLixeiras, tiposLixeira);

        if (repositorio.findById(id) == null) {
            repositorio.save(novoPontoColeta);
        } else {
            throw new PontoColetaException("Error - Já existe um ponto de coleta com este 'ID'.");
        }
    }

    public void atualizarPontoColeta(
            String idOriginal,
            String id,
            String localizacao,
            int numeroLixeiras,
            List<String> tiposLixeira) {

        ValidatePontoColeta valid = new ValidatePontoColeta();
        PontoDeColeta pontoColetaAtualizado = valid.validacao(id, localizacao, numeroLixeiras, tiposLixeira);
        pontoColetaAtualizado.setId(idOriginal);

        repositorio.update(pontoColetaAtualizado);
    }

    public PontoDeColeta buscarPontoColeta(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirPontoColeta(String id) {
        PontoDeColeta pontoColeta = repositorio.findById(id);
        if (pontoColeta != null) {
            repositorio.delete(pontoColeta);
        } else {
            throw new PontoColetaException("Error - Ponto de coleta inexistente.");
        }
    }

    public String imprimirListaPontosColeta() {
        String listagemPontosColeta = "";

        for (Object obj : this.repositorio.findAll()) {
            PontoDeColeta pontoColeta = (PontoDeColeta) obj;
            listagemPontosColeta += pontoColeta.toString();
        }

        return listagemPontosColeta;
    }
}
