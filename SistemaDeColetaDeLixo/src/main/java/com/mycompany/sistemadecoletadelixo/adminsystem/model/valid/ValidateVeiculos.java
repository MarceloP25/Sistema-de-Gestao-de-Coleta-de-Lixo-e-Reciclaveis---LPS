/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Veiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.VeiculoException;
import javax.swing.JComboBox;

/**
 *
 * @author Edu
 */


public class ValidateVeiculos {

    public Veiculo validaCamposEntrada(
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
        
        Veiculo veiculo = new Veiculo();

        if (placa == null || placa.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'placa'.");
        }
        if (!placa.matches("[A-Z]{3}\\d{4}")) {
            throw new VeiculoException("Error - Formato inválido: 'placa'. Use o formato ABC1234.");
        }
        veiculo.setPlaca(placa);

        if (chassi == null || chassi.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'chassi'.");
        }
        if (!chassi.matches("[A-Z0-9]{17}")) {
            throw new VeiculoException("Error - Formato inválido: 'chassi'. Deve conter 17 caracteres alfanuméricos.");
        }
        veiculo.setChassi(chassi);

        if (peso <= 0) {
            throw new VeiculoException("Error - Peso do veículo deve ser maior que zero.");
        }
        veiculo.setPesoVeiculo(peso);
        
        if (quilometragem < 0) {
            throw new VeiculoException("Error - Quilometragem não pode ser negativa.");
        }
        veiculo.setQuilometragem(quilometragem);

        if (eixos <= 0) {
            throw new VeiculoException("Error - Número de eixos deve ser maior que zero.");
        }
        veiculo.setEixos(eixos);
        
        if (comprimento <= 0) {
            throw new VeiculoException("Error - Comprimento deve ser maior que zero.");
        }
        veiculo.setComprimento(comprimento);
        
        if (altura <= 0) {
            throw new VeiculoException("Error - Altura deve ser maior que zero.");
        }
        veiculo.setAltura(altura);
        
        if (largura <= 0) {
            throw new VeiculoException("Error - Largura deve ser maior que zero.");
        }
        veiculo.setLargura(largura);
        
        if (cargaMaxima <= 0) {
            throw new VeiculoException("Error - Carga máxima deve ser maior que zero.");
        }
        veiculo.setCargaMaxima(cargaMaxima);
        
        if (consumo <= 0) {
            throw new VeiculoException("Error - Consumo deve ser maior que zero.");
        }
        veiculo.setConsumo(consumo);
        
        if (emissaoPoluentes < 0) {
            throw new VeiculoException("Error - Emissão de poluentes não pode ser negativa.");
        }
        veiculo.setEmissaoPoluentes(emissaoPoluentes);

        if (tipoCarteiraCondutor == null || tipoCarteiraCondutor.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'tipoCarteiraCondutor'.");
        }
        veiculo.setCarteira(tipoCarteiraCondutor);
        
        if (tipoCombustivel == null || tipoCombustivel.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'tipoCombustivel'.");
        }
        veiculo.setCombustivel(tipoCombustivel);

        if (manutencao) {
            if (dataManutencao == null || dataManutencao.isEmpty()) {
                throw new VeiculoException("Error - O veículo está em manutenção, mas a data de manutenção não foi informada.");
            }
        }
        veiculo.setManutencao(manutencao);
        veiculo.setDataManutencao(dataManutencao);

        return veiculo;
    }
}
