/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.EstacaoDescarga;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.EstaçãoDescargaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateEstacaoDescarga;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.EstacaoDescargaException;

/**
 *
 * @author eduhe
 */
public class EstacaoDescargaController {

    private EstaçãoDescargaDAO repositorio;

    public EstacaoDescargaController() {
        repositorio = new EstaçãoDescargaDAO();
    }

    public void cadastrarEstacaoDescarga(
            String id,
            int numeroSupervisores,
            String supervisor,
            int capacidade) {

        ValidateEstacaoDescarga valid = new ValidateEstacaoDescarga();
        EstacaoDescarga novaEstacaoDescarga = valid.validacao(id, numeroSupervisores, supervisor, capacidade);

        if (repositorio.findById(id) == null) {
            repositorio.save(novaEstacaoDescarga);
        } else {
            throw new EstacaoDescargaException("Error - Já existe uma estação de descarga com este 'ID'.");
        }
    }

    public void atualizarEstacaoDescarga(
            String idOriginal,
            String id,
            int numeroSupervisores,
            String supervisor,
            int capacidade) {

        ValidateEstacaoDescarga valid = new ValidateEstacaoDescarga();
        EstacaoDescarga estacaoAtualizada = valid.validacao(id, numeroSupervisores, supervisor, capacidade);
        estacaoAtualizada.setId(idOriginal);

        repositorio.update(estacaoAtualizada);
    }

    public EstacaoDescarga buscarEstacaoDescarga(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirEstacaoDescarga(String id) {
        EstacaoDescarga estacaoDescarga = repositorio.findById(id);
        if (estacaoDescarga != null) {
            repositorio.delete(estacaoDescarga);
        } else {
            throw new EstacaoDescargaException("Error - Estação de descarga inexistente.");
        }
    }

    public String imprimirListaEstacoesDescarga() {
        String listagemEstacoes = "";

        for (Object obj : this.repositorio.findAll()) {
            EstacaoDescarga estacaoDescarga = (EstacaoDescarga) obj;
            listagemEstacoes += estacaoDescarga.toString();
        }

        return listagemEstacoes;
    }
}
