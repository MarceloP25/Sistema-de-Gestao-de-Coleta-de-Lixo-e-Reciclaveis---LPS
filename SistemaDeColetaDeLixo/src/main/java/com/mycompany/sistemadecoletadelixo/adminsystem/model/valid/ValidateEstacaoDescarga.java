/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.EstacaoDescarga;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.EstacaoDescargaException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
/**
 *
 * @author Edu
 */

public class ValidateEstacaoDescarga {

    public EstacaoDescarga validaCamposEntrada(String nome, String capacidadeProcessamento, JComboBox<String> supervisorMaquinario,
                                               JComboBox<String> departamento, JCheckBox[] materiaisProcessamento) {
        EstacaoDescarga estacao = new EstacaoDescarga();

        // Validação do Nome
        if (nome.isEmpty())
            throw new EstacaoDescargaException("Error - Campo vazio: 'nome da estação'.");
        estacao.setNome(nome);

        // Validação da Capacidade de Processamento
        if (capacidadeProcessamento.isEmpty())
            throw new EstacaoDescargaException("Error - Campo vazio: 'capacidade de processamento'.");
        if (!capacidadeProcessamento.matches("^[0-9]+(\\.[0-9]+)?$")) // Valida números inteiros ou decimais
            throw new EstacaoDescargaException("Error - Valor inválido no campo 'capacidade de processamento'. Use um número válido.");
        estacao.setCapacidadeProcessamento(Double.parseDouble(capacidadeProcessamento));

        if (supervisorMaquinario.getSelectedItem() == null || supervisorMaquinario.getSelectedItem().toString().isEmpty())
            throw new EstacaoDescargaException("Error - Nenhum supervisor do maquinário selecionado.");
        estacao.setSupervisor(supervisorMaquinario.getSelectedItem().toString());

        // Validação do Departamento
        if (departamento.getSelectedItem() == null || departamento.getSelectedItem().toString().isEmpty())
            throw new EstacaoDescargaException("Error - Nenhum departamento selecionado.");
        estacao.setDepartamento(departamento.getSelectedItem().toString());

        // Validação dos Materiais de Processamento
        boolean peloMenosUmSelecionado = false;
        StringBuilder materiaisSelecionados = new StringBuilder();
        for (JCheckBox material : materiaisProcessamento) {
            if (material.isSelected()) {
                peloMenosUmSelecionado = true;
                if (materiaisSelecionados.length() > 0) {
                    materiaisSelecionados.append(", ");
                }
                materiaisSelecionados.append(material.getText());
            }
        }
        if (!peloMenosUmSelecionado)
            throw new EstacaoDescargaException("Error - Nenhum material de processamento selecionado.");
        estacao.setMateriaisProcessamento(materiaisSelecionados.toString());

        return estacao;
    }
}

