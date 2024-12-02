/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Rota;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.RotaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateRota;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.RotaException;

/**
 *
 * @author eduhe
 */
public class RotasController {

    private RotaDAO repositorio;

    public RotasController() {
        repositorio = new RotaDAO();
    }

    public void cadastrarRota(
            String id,
            String pontoInicio,
            String pontoFinalizacao,
            List<String> ruasPercorridas,
            List<String> pontosColeta,
            String supervisor,
            List<String> operadores) {

        ValidateRota valid = new ValidateRota();
        Rota novaRota = valid.validacao(id, pontoInicio, pontoFinalizacao, ruasPercorridas, pontosColeta, supervisor, operadores);

        if (repositorio.findById(id) == null) {
            repositorio.save(novaRota);
        } else {
            throw new RotaException("Error - Já existe uma rota com este 'ID'.");
        }
    }

    public void atualizarRota(
            String idOriginal,
            String id,
            String pontoInicio,
            String pontoFinalizacao,
            List<String> ruasPercorridas,
            List<String> pontosColeta,
            String supervisor,
            List<String> operadores) {

        ValidateRota valid = new ValidateRota();
        Rota rotaAtualizada = valid.validacao(id, pontoInicio, pontoFinalizacao, ruasPercorridas, pontosColeta, supervisor, operadores);
        rotaAtualizada.setId(idOriginal);

        repositorio.update(rotaAtualizada);
    }

    public Rota buscarRota(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirRota(String id) {
        Rota rota = repositorio.findById(id);
        if (rota != null) {
            repositorio.delete(rota);
        } else {
            throw new RotaException("Error - Rota inexistente.");
        }
    }

    public String imprimirListaRotas() {
        String listagemRotas = "";

        for (Object obj : this.repositorio.findAll()) {
            Rota rota = (Rota) obj;
            listagemRotas += rota.toString();
        }

        return listagemRotas;
    }
}
