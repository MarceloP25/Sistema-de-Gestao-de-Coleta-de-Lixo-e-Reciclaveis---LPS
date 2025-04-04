/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Operador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Veiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.VeiculoException;
import java.util.List;

/**
 *
 * @author Edu
 */
public class ValidateVeiculos {

    private char carteiraConducao;
    private Object combustivel;
    private Object operador;
    

    public Veiculo validaCamposEntrada(
    String placa,
    String chassi,
    String modelo,
    double consumoPorKm,
    int eixos,
    int carga,
    double comprimento,
    double altura,
    double largura,
    String tipoCarteiraCondutor,
    String tipoCombustivel,
    String dataManutencao,
    Departamento departamento,
    List<Operador> operadores) {
        
        Veiculo veiculo = new Veiculo();

        // Validação da placa
        if (placa == null || placa.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'placa'.");
        }
        if (!placa.matches("[A-Z]{3}\\d{4}")) {
            throw new VeiculoException("Error - Formato inválido: 'placa'. Use o formato ABC1234.");
        }
        veiculo.setPlaca(placa);

        // Validação do chassi
        if (chassi == null || chassi.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'chassi'.");
        }
        if (!chassi.matches("[A-Z0-9]{17}")) {
            throw new VeiculoException("Error - Formato inválido: 'chassi'. Deve conter 17 caracteres alfanuméricos.");
        }
        veiculo.setChassi(chassi);
        
        // Validação do modelo
        if (modelo == null || modelo.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'modelo'.");
        }
        veiculo.setModelo(modelo);
        
        // Validação do consumo por km
        if (consumoPorKm <= 0) {
            throw new VeiculoException("Error - Consumo por km deve ser maior que zero.");
        }
        veiculo.setConsumoPorKm((float) consumoPorKm);

        // Validação do número de eixos
        if (eixos <= 0) {
            throw new VeiculoException("Error - Número de eixos deve ser maior que zero.");
        }
        veiculo.setEixos(eixos);

        // Validação do comprimento
        if (comprimento <= 0) {
            throw new VeiculoException("Error - Comprimento deve ser maior que zero.");
        }
        veiculo.setComprimento((float) comprimento);

        // Validação da altura
        if (altura <= 0) {
            throw new VeiculoException("Error - Altura deve ser maior que zero.");
        }
        veiculo.setAltura((float) altura);

        // Validação da largura
        if (largura <= 0) {
            throw new VeiculoException("Error - Largura deve ser maior que zero.");
        }
        veiculo.setLargura((float) largura);

        // Validação da carteira de condução
       if (tipoCarteiraCondutor == null || tipoCarteiraCondutor.isEmpty()) {
        throw new VeiculoException("Error - Campo vazio: 'carteiraConducao'.");
        }
        veiculo.setCarteiraConducao(tipoCarteiraCondutor.charAt(0));

        // Validação da carga
        if (carga <= 0) {
            throw new VeiculoException("Error - Carga deve ser maior que zero.");
        }
        veiculo.setCarga(carga);

        // Validação do tipo de combustível
        if (combustivel != null && combustivel instanceof String && !((String) combustivel).isEmpty()) {
            veiculo.setCombustivel((String) combustivel);
        } else {
            throw new VeiculoException("Error - Campo vazio: 'combustivel'.");
        }
        
        // Validação da data de manutenção
        if (dataManutencao == null || dataManutencao.isEmpty()) {
            throw new VeiculoException("Error - Campo vazio: 'dataManutencao'.");
        }
        veiculo.setDataManutencao(dataManutencao);

        // Validação do departamento
        if (departamento == null) {
            throw new VeiculoException("Error - Departamento não pode ser nulo.");
        }
        veiculo.setDepartamento((Departamento) departamento);

        // Validação da lista de operadores
        if (operador != null && operador instanceof List<?> && !((List<?>) operador).isEmpty()) {
            veiculo.setOperador((List<Operador>) operador);
        } else {
            throw new VeiculoException("Error - Lista de operadores não pode ser vazia.");
        }

        return veiculo;
    }
}