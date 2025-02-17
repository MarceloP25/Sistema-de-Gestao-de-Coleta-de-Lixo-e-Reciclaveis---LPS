/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.PontoDeColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.PontoDeColetaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        if (nomeRota.getSelectedItem() == null || nomeRota.getSelectedItem().toString().isEmpty()) {
            throw new PontoDeColetaException("Error - Nenhuma rota selecionada.");
        }
        pontoColeta.setNomeRota(nomeRota.getSelectedItem().toString());

        if (nomeRuas.getSelectedItem() == null || nomeRuas.getSelectedItem().toString().isEmpty()) {
            throw new PontoDeColetaException("Error - Nenhuma rua selecionada.");
        }
        pontoColeta.setRua(nomeRuas.getSelectedItem().toString());

        if (numeroLixeiras.isEmpty()) {
            throw new PontoDeColetaException("Error - Campo vazio: 'número de lixeiras'.");
        }
        if (!numeroLixeiras.matches("\\d+")) {
            throw new PontoDeColetaException("Error - Valor inválido no campo 'número de lixeiras'. Apenas números são permitidos.");
        }
        pontoColeta.setNumeroLixeiras(Integer.parseInt(numeroLixeiras));

        boolean peloMenosUmSelecionado = false;
        for (JCheckBox tipo : tiposLixeiras) {
            if (tipo.isSelected()) {
                peloMenosUmSelecionado = true;
                break;
            }
        }
        if (!peloMenosUmSelecionado) {
            throw new PontoDeColetaException("Error - Pelo menos um tipo de lixeira deve ser selecionado.");
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
        List<String> listaTipos = new ArrayList<>(Arrays.asList(tiposSelecionados.toString().split(", ")));
        pontoColeta.setTiposLixo(listaTipos);


        return pontoColeta;
    }
}
