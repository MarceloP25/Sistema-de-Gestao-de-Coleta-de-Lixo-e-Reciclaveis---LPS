/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Rota;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.RotaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateRota;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.RotaException;
import java.util.List;
import javax.swing.JComboBox;

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
            Long id, String nomeRota, String ruaInicio, String ruaFim, List<String> ruasPercorridas,
            JComboBox<String> departamento, JComboBox<String> supervisor) {

        ValidateRota valid = new ValidateRota();
        Rota novaRota = valid.validaCamposEntrada( nomeRota, ruaInicio, ruaFim, ruasPercorridas, departamento, supervisor);

        if (repositorio.find(id) == null) {
            repositorio.save(novaRota);
        } else {
            throw new RotaException("Error - Já existe uma rota com este 'ID'.");
        }
    }

    public void atualizarRota(
            Long id, String nomeRota, String ruaInicio, String ruaFim, List<String> ruasPercorridas,
            JComboBox<String> departamento, JComboBox<String> supervisor) {

        ValidateRota valid = new ValidateRota();
        Rota rotaAtualizada = valid.validaCamposEntrada(nomeRota, ruaInicio, ruaFim, ruasPercorridas, departamento, supervisor);
        rotaAtualizada.setId(id);

        repositorio.update(rotaAtualizada);
    }

    public Rota buscarRota(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirRota(Long id) {
        Rota rota = repositorio.find(id);
        if (rota != null) {
            repositorio.delete(id);
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
