/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.PontoDeColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.PontoDeColetaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidatePontosColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.PontoDeColetaException;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

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
            Long id, JComboBox<String> nomeRota, JComboBox<String> nomeRuas, 
            String numeroLixeiras, JCheckBox[] tiposLixeiras) {

        ValidatePontosColeta valid = new ValidatePontosColeta();
        PontoDeColeta novoPontoColeta = valid.validaCamposEntrada( nomeRota, nomeRuas, numeroLixeiras, tiposLixeiras);

        if (repositorio.find(id) == null) {
            repositorio.save(novoPontoColeta);
        } else {
            throw new PontoDeColetaException("Error - Já existe um ponto de coleta com este 'ID'.");
        }
    }

    public void atualizarPontoColeta(
            Long id, JComboBox<String> nomeRota, JComboBox<String> nomeRuas, 
            String numeroLixeiras, JCheckBox[] tiposLixeiras) {

        ValidatePontosColeta valid = new ValidatePontosColeta();
        PontoDeColeta pontoColetaAtualizado = valid.validaCamposEntrada( nomeRota, nomeRuas, numeroLixeiras, tiposLixeiras);
        pontoColetaAtualizado.setId(id);

        repositorio.update(pontoColetaAtualizado);
    }

    public PontoDeColeta buscarPontoColeta(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirPontoColeta(Long id) {
        PontoDeColeta pontoColeta = repositorio.find(id);
        if (pontoColeta != null) {
            repositorio.delete(id);
        } else {
            throw new PontoDeColetaException("Error - Ponto de coleta inexistente.");
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
