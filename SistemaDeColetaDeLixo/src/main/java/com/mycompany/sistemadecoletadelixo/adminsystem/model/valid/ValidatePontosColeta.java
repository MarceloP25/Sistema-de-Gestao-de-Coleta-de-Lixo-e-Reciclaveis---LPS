/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.PontoDeColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.PontoColetaException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
/**
 *
 * @author Edu
 */
public class ValidatePontosColeta {

    public PontoDeColeta validaCamposEntrada(JComboBox<String> nomeRota, JComboBox<String> nomeRuas,
                                           String numeroLixeiras, JCheckBox[] tiposLixeiras) {
        PontoDeColeta pontoColeta = new PontoDeColeta();

        // Validação do Nome da Rota (JComboBox)
        if (nomeRota.getSelectedItem() == null || nomeRota.getSelectedItem().toString().isEmpty()) {
            throw new PontoColetaException("Error - Nenhuma rota selecionada.");
        }
        pontoColeta.setNomeRota(nomeRota.getSelectedItem().toString());

        // Validação do Nome das Ruas (JComboBox)
        if (nomeRuas.getSelectedItem() == null || nomeRuas.getSelectedItem().toString().isEmpty()) {
            throw new PontoColetaException("Error - Nenhuma rua selecionada.");
        }
        pontoColeta.setNomeRua(nomeRuas.getSelectedItem().toString());

        // Validação do Número de Lixeiras
        if (numeroLixeiras.isEmpty()) {
            throw new PontoColetaException("Error - Campo vazio: 'número de lixeiras'.");
        }
        if (!numeroLixeiras.matches("\\d+")) {
            throw new PontoColetaException("Error - Valor inválido no campo 'número de lixeiras'. Apenas números são permitidos.");
        }
        pontoColeta.setNumeroLixeiras(Integer.parseInt(numeroLixeiras));

        // Validação dos Tipos de Lixeiras (JCheckBox)
        boolean peloMenosUmSelecionado = false;
        for (JCheckBox tipo : tiposLixeiras) {
            if (tipo.isSelected()) {
                peloMenosUmSelecionado = true;
                break;
            }
        }
        if (!peloMenosUmSelecionado) {
            throw new PontoColetaException("Error - Pelo menos um tipo de lixeira deve ser selecionado.");
        }

        StringBuilder tiposSelecionados = new StringBuilder();
        for (JCheckBox tipo : tiposLixeiras) {
            if (tipo.isSelected()) {
                if (tiposSelecionados.length() > 0) {
                    tiposSelecionados.append(", ");
                }
                tiposSelecionados.append(tipo.getText());
            }
        }
        pontoColeta.setTiposLixeiras(tiposSelecionados.toString());

        return pontoColeta;
    }
}
