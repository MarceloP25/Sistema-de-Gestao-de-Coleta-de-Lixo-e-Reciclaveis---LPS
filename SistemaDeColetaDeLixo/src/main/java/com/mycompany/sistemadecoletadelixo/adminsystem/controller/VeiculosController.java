/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Veiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.VeiculoDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateVeiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.VeiculoException;

/**
 *
 * @author eduhe
 */
public class VeiculosController {

    private VeiculoDAO repositorio;

    public VeiculosController() {
        repositorio = new VeiculoDAO();
    }

    public void cadastrarVeiculo(
            String id,
            String placa,
            String chassi,
            double peso,
            double quilometragem,
            int eixos,
            double comprimento,
            double altura,
            double largura,
            String tipoCarteiraCondutor,
            double cargaMaxima,
            double consumo,
            String tipoCombustivel,
            boolean manutencao,
            String dataManutencao,
            double emissaoPoluentes) {

        ValidateVeiculo valid = new ValidateVeiculo();
        Veiculo novoVeiculo = valid.validacao(
                id, placa, chassi, peso, quilometragem, eixos, comprimento, altura, largura, tipoCarteiraCondutor,
                cargaMaxima, consumo, tipoCombustivel, manutencao, dataManutencao, emissaoPoluentes);

        if (repositorio.findById(id) == null) {
            repositorio.save(novoVeiculo);
        } else {
            throw new VeiculoException("Error - Já existe um veículo com este 'ID'.");
        }
    }

    public void atualizarVeiculo(
            String idOriginal,
            String id,
            String placa,
            String chassi,
            double peso,
            double quilometragem,
            int eixos,
            double comprimento,
            double altura,
            double largura,
            String tipoCarteiraCondutor,
            double cargaMaxima,
            double consumo,
            String tipoCombustivel,
            boolean manutencao,
            String dataManutencao,
            double emissaoPoluentes) {

        ValidateVeiculo valid = new ValidateVeiculo();
        Veiculo veiculoAtualizado = valid.validacao(
                id, placa, chassi, peso, quilometragem, eixos, comprimento, altura, largura, tipoCarteiraCondutor,
                cargaMaxima, consumo, tipoCombustivel, manutencao, dataManutencao, emissaoPoluentes);

        veiculoAtualizado.setId(idOriginal);

        repositorio.update(veiculoAtualizado);
    }

    public Veiculo buscarVeiculo(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirVeiculo(String id) {
        Veiculo veiculo = repositorio.findById(id);
        if (veiculo != null) {
            repositorio.delete(veiculo);
        } else {
            throw new VeiculoException("Error - Veículo inexistente.");
        }
    }

    public String imprimirListaVeiculos() {
        String listagemVeiculos = "";

        for (Object obj : this.repositorio.findAll()) {
            Veiculo veiculo = (Veiculo) obj;
            listagemVeiculos += veiculo.toString();
        }

        return listagemVeiculos;
    }
}
