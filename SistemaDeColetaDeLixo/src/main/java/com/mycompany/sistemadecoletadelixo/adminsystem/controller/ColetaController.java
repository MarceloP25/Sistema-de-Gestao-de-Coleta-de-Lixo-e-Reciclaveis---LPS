/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Coleta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.ColetaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.ColetaException;
import javax.swing.JComboBox;

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
        JComboBox<String> supervisor, JComboBox<String> operador, JComboBox<String> rota,
        JComboBox<String> veiculo, JComboBox<String> materiaisColetados, String peso) {

    String supervisorSelecionado = (String) supervisor.getSelectedItem();
    String operadorSelecionado = (String) operador.getSelectedItem();
    String rotaSelecionada = (String) rota.getSelectedItem();
    String veiculoSelecionado = (String) veiculo.getSelectedItem();
    String materiaisSelecionados = (String) materiaisColetados.getSelectedItem();

    ValidateColeta valid = new ValidateColeta();
    Coleta novaColeta = valid.validaCamposEntrada(
            supervisorSelecionado, peso, materiaisSelecionados, operadorSelecionado, rotaSelecionada, veiculoSelecionado
    );

    // Salvar a coleta no repositório
    if (repositorio.findById(novaColeta.getId()) == null) {
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
