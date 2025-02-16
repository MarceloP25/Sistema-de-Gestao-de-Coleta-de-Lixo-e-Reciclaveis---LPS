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

    

    ValidateColeta valid = new ValidateColeta();
    Coleta novaColeta = valid.validaCamposEntrada(
            supervisor, operador, rota, veiculo, materiaisColetados, peso
    );

    if (repositorio.find(novaColeta.getId()) == null) {
        repositorio.save(novaColeta);
    } else {
        throw new ColetaException("Error - Já existe uma coleta com este 'ID'.");
    }
}


    public void atualizarColeta(
            Long id, JComboBox<String> supervisor, JComboBox<String> operador, JComboBox<String> rota,
        JComboBox<String> veiculo, JComboBox<String> materiaisColetados, String peso) {

        ValidateColeta valid = new ValidateColeta();
        Coleta coletaAtualizada = valid.validaCamposEntrada(
                supervisor, operador, rota, veiculo, materiaisColetados, peso);

        coletaAtualizada.setId(id);

        repositorio.update(coletaAtualizada);
    }

    public Coleta buscarColeta(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirColeta(Long id) {
        Coleta coleta = repositorio.find(id);
        if (coleta != null) {
            repositorio.delete(id);
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
