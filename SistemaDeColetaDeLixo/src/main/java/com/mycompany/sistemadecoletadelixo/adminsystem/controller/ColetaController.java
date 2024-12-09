/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Coleta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.ColetaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.ColetaException;

/**
 *
 * @author eduhe
 */
public class ColetaController {

    private ColetaDAO repositorio;

    public ColetaController() {
        repositorio = new ColetaDAO();
    }

    public void cadastrarColeta(
            String id,
            String supervisor,
            double peso,
            String materiaisColetados,
            String operador,
            String rota,
            String veiculo) {

        ValidateColeta valid = new ValidateColeta();
        Coleta novaColeta = valid.validacao(
                id, supervisor, peso, materiaisColetados, operador, rota, veiculo);

        if (repositorio.findById(id) == null) {
            repositorio.save(novaColeta);
        } else {
            throw new ColetaException("Error - Já existe uma coleta com este 'ID'.");
        }
    }

    public void atualizarColeta(
            String idOriginal,
            String id,
            String supervisor,
            double peso,
            String materiaisColetados,
            String operador,
            String rota,
            String veiculo) {

        ValidateColeta valid = new ValidateColeta();
        Coleta coletaAtualizada = valid.validacao(
                id, supervisor, peso, materiaisColetados, operador, rota, veiculo);

        coletaAtualizada.setId(idOriginal);

        repositorio.update(coletaAtualizada);
    }

    public Coleta buscarColeta(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirColeta(String id) {
        Coleta coleta = repositorio.findById(id);
        if (coleta != null) {
            repositorio.delete(coleta);
        } else {
            throw new ColetaException("Error - Coleta inexistente.");
        }
    }

    public String imprimirListaColetas() {
        String listagemColetas = "";

        for (Object obj : this.repositorio.findAll()) {
            Coleta coleta = (Coleta) obj;
            listagemColetas += coleta.toString();
        }

        return listagemColetas;
    }
}
