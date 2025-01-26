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

    public Veiculo validaCamposEntrada(String placa, String chassi, String pesoVeiculo, String eixos, String quilometragem,
                                       String comprimento, String altura, String largura, String carteira, String cargaMaxima,
                                       String combustivel, JComboBox<String> consumo, JComboBox<String> emissaoPoluentes) {
        Veiculo veiculo = new Veiculo();

        // Validação da Placa
        if (placa == null || placa.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'placa'.");
        }
        if (!placa.matches("[A-Z]{3}\\d{4}")) {
            throw new VeiculoException("Error - Formato inválido: 'placa'. Use o formato ABC1234.");
        }
        veiculo.setPlaca(placa);

        // Validação do Chassi
        if (chassi == null || chassi.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'chassi'.");
        }
        if (!chassi.matches("[A-Z0-9]{17}")) {
            throw new VeiculoException("Error - Formato inválido: 'chassi'. Deve conter 17 caracteres alfanuméricos.");
        }
        veiculo.setChassi(chassi);

        // Validação do Peso do Veículo
        if (pesoVeiculo == null || pesoVeiculo.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'peso do veículo'.");
        }
        if (!pesoVeiculo.matches("\\d+(\\.\\d{1,2})?")) {
            throw new VeiculoException("Error - Valor inválido: 'peso do veículo'. Use apenas números (ex: 1500.50).");
        }
        veiculo.setPesoVeiculo(Double.parseDouble(pesoVeiculo));

        // Validação do Número de Eixos
        if (eixos == null || eixos.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'eixos'.");
        }
        if (!eixos.matches("\\d+")) {
            throw new VeiculoException("Error - Valor inválido: 'eixos'. Deve conter apenas números.");
        }
        veiculo.setEixos(Integer.parseInt(eixos));

        // Validação da Quilometragem
        if (quilometragem == null || quilometragem.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'quilometragem'.");
        }
        if (!quilometragem.matches("\\d+(\\.\\d{1,2})?")) {
            throw new VeiculoException("Error - Valor inválido: 'quilometragem'. Use apenas números (ex: 12345.67).");
        }
        veiculo.setQuilometragem(Double.parseDouble(quilometragem));

        // Validação do Comprimento
        if (comprimento == null || comprimento.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'comprimento'.");
        }
        if (!comprimento.matches("\\d+(\\.\\d{1,2})?")) {
            throw new VeiculoException("Error - Valor inválido: 'comprimento'. Use apenas números (ex: 12.34).");
        }
        veiculo.setComprimento(Double.parseDouble(comprimento));

        // Validação da Altura
        if (altura == null || altura.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'altura'.");
        }
        if (!altura.matches("\\d+(\\.\\d{1,2})?")) {
            throw new VeiculoException("Error - Valor inválido: 'altura'. Use apenas números (ex: 3.45).");
        }
        veiculo.setAltura(Double.parseDouble(altura));

        // Validação da Largura
        if (largura == null || largura.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'largura'.");
        }
        if (!largura.matches("\\d+(\\.\\d{1,2})?")) {
            throw new VeiculoException("Error - Valor inválido: 'largura'. Use apenas números (ex: 2.50).");
        }
        veiculo.setLargura(Double.parseDouble(largura));

        // Validação da Carteira
        if (carteira == null || carteira.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'carteira'.");
        }
        veiculo.setCarteira(carteira);

        // Validação da Carga Máxima
        if (cargaMaxima == null || cargaMaxima.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'carga máxima'.");
        }
        if (!cargaMaxima.matches("\\d+(\\.\\d{1,2})?")) {
            throw new VeiculoException("Error - Valor inválido: 'carga máxima'. Use apenas números (ex: 3000.00).");
        }
        veiculo.setCargaMaxima(Double.parseDouble(cargaMaxima));

        // Validação do Combustível
        if (combustivel == null || combustivel.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'combustível'.");
        }
        veiculo.setCombustivel(combustivel);

        // Validação do Consumo (JComboBox)
        if (consumo.getSelectedItem() == null || consumo.getSelectedItem().toString().isEmpty()) {
            throw new VeiculoException("Error - Nenhuma opção selecionada no campo 'consumo'.");
        }
        veiculo.setConsumo(consumo.getSelectedItem().toString());

        // Validação da Emissão de Poluentes (JComboBox)
        if (emissaoPoluentes.getSelectedItem() == null || emissaoPoluentes.getSelectedItem().toString().isEmpty()) {
            throw new VeiculoException("Error - Nenhuma opção selecionada no campo 'emissão de poluentes'.");
        }
        veiculo.setEmissaoPoluentes(emissaoPoluentes.getSelectedItem().toString());

        return veiculo;
    }
}

