/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Veiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.VeiculoDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Operador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateVeiculos;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.VeiculoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduhe, arthu
 */
public class VeiculosController {

    private final VeiculoDAO repositorio;
    private final ValidateVeiculos valid;

    public VeiculosController() {
        repositorio = new VeiculoDAO();
        valid = new ValidateVeiculos();
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

        
        
        Veiculo novoVeiculo = valid.validaCamposEntrada(
                placa,
                chassi,
                "",                         
                consumo,                     
                eixos,
                (int) cargaMaxima,           
                comprimento,
                altura,
                largura,
                tipoCarteiraCondutor,       
                tipoCombustivel,
                dataManutencao,
                new Departamento(),          
                new ArrayList<>()            
        );

        novoVeiculo.setId(id);
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
            String modelo,
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
            Departamento departamento,
            double emissaoPoluentes,
            List<Operador> operadores) {

        Veiculo veiculoAtualizado = valid.validaCamposEntrada(
                placa,
                chassi,
                modelo,
                consumo,
                eixos,
                (int) cargaMaxima,
                comprimento,
                altura,
                largura,
                tipoCarteiraCondutor,
                tipoCombustivel,
                dataManutencao,
                departamento,
                operadores
        );

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
