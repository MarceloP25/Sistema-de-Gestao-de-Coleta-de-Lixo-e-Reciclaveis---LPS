package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.*;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.EstacaoDescargaException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ValidateEstacaoDescarga {

    public EstacaoDescarga validaCamposEntrada(
        String nome, 
        String capacidadeProcessamento, 
        JComboBox<String> supervisor,
        JComboBox<String> departamento, 
        JCheckBox[] materiaisProcessamento) {

    EstacaoDescarga estacao = new EstacaoDescarga();

    // Validação do nome
    if (nome == null || nome.trim().isEmpty()) {
        throw new EstacaoDescargaException("Error - Campo vazio: 'nome da estação'.");
    }
    estacao.setNome(nome.trim());

    // Validação da capacidade de processamento
    if (capacidadeProcessamento == null || capacidadeProcessamento.trim().isEmpty()) {
        throw new EstacaoDescargaException("Error - Campo vazio: 'capacidade de processamento'.");
    }
    try {
        float capacidade = Float.parseFloat(capacidadeProcessamento.trim());
        if (capacidade <= 0) {
            throw new EstacaoDescargaException("Error - Capacidade de processamento deve ser maior que zero.");
        }
        estacao.setCapacidadeProcessamento(capacidade);
    } catch (NumberFormatException e) {
        throw new EstacaoDescargaException("Error - Valor inválido no campo 'capacidade de processamento'. Use um número válido.");
    }

    // Validação do supervisor
    if (supervisor.getSelectedItem() == null || supervisor.getSelectedItem().toString().trim().isEmpty()) {
        throw new EstacaoDescargaException("Error - Nenhum supervisor do maquinário selecionado.");
    }
    estacao.setSupervisor((Supervisor) supervisor.getSelectedItem());

    // Validação do departamento
    Departamento deptoSelecionado = (Departamento) departamento.getSelectedItem();
    if (deptoSelecionado == null) {
        throw new EstacaoDescargaException("Error - Nenhum departamento selecionado.");
    }
    List<Departamento> listaDepartamentos = new ArrayList<>();
    listaDepartamentos.add(deptoSelecionado);
    estacao.setDepartamento(listaDepartamentos);

    // Validação dos materiais de processamento
    List<String> materiaisSelecionados = new ArrayList<>();
    for (JCheckBox material : materiaisProcessamento) {
        if (material.isSelected()) {
            materiaisSelecionados.add(material.getText());
        }
    }
    if (materiaisSelecionados.isEmpty()) {
        throw new EstacaoDescargaException("Error - Nenhum material de processamento selecionado.");
    }
    estacao.setMateriaisProcessamento(materiaisSelecionados);

    return estacao;
}
}