/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Veiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.VeiculoDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateVeiculos;
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
            Long id,
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

        ValidateVeiculos valid = new ValidateVeiculos();
        Veiculo novoVeiculo = valid.validaCamposEntrada(
                id, placa, chassi, peso, quilometragem, eixos, comprimento, altura, largura, tipoCarteiraCondutor,
                cargaMaxima, consumo, tipoCombustivel, manutencao, dataManutencao, emissaoPoluentes);

        if (repositorio.find(id) == null) {
            repositorio.save(novoVeiculo);
        } else {
            throw new VeiculoException("Error - Já existe um veículo com este 'ID'.");
        }
    }

    public void atualizarVeiculo(
            Long id,
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

        ValidateVeiculos valid = new ValidateVeiculos();
        Veiculo veiculoAtualizado = valid.validaCamposEntrada(
                 placa, chassi, peso, quilometragem, eixos, comprimento, altura, largura, tipoCarteiraCondutor,
                cargaMaxima, consumo, tipoCombustivel, manutencao, dataManutencao, emissaoPoluentes);

        veiculoAtualizado.setId(id);

        repositorio.update(veiculoAtualizado);
    }

    public Veiculo buscarVeiculo(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirVeiculo(Long id) {
        Veiculo veiculo = repositorio.find(id);
        if (veiculo != null) {
            repositorio.delete(id);
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
