/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Rota;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.RotaException;
import javax.swing.JComboBox;
import java.util.List;

/**
 *
 * @author Edu
 */
public class ValidateRota {

    public Rota validaCamposEntrada(String nomeRota, String ruaInicio, String ruaFim, List<String> ruasPercorridas,
                                    JComboBox<String> departamento, JComboBox<String> supervisor) {
        Rota rota = new Rota();

        // Validação do Nome da Rota
        if (nomeRota == null || nomeRota.isEmpty()) {
            throw new RotaException("Error - Campo vazio: 'nome da rota'.");
        }
        rota.setNomeRota(nomeRota);

        // Validação da Rua de Início
        if (ruaInicio == null || ruaInicio.isEmpty()) {
            throw new RotaException("Error - Campo vazio: 'rua de início'.");
        }
        rota.setRuaInicio(ruaInicio);

        // Validação da Rua de Fim
        if (ruaFim == null || ruaFim.isEmpty()) {
            throw new RotaException("Error - Campo vazio: 'rua de fim'.");
        }
        rota.setRuaFim(ruaFim);

        // Validação das Ruas Percorridas
        if (ruasPercorridas == null || ruasPercorridas.isEmpty()) {
            throw new RotaException("Error - Nenhuma rua foi adicionada à rota.");
        }
        rota.setRuasPercorridas(ruasPercorridas);

        // Validação do Departamento (JComboBox)
        if (departamento.getSelectedItem() == null || departamento.getSelectedItem().toString().isEmpty()) {
            throw new RotaException("Error - Nenhum departamento selecionado.");
        }
        rota.setDepartamento(departamento.getSelectedItem().toString());

        // Validação do Supervisor (JComboBox)
        if (supervisor.getSelectedItem() == null || supervisor.getSelectedItem().toString().isEmpty()) {
            throw new RotaException("Error - Nenhum supervisor selecionado.");
        }
        rota.setSupervisor(supervisor.getSelectedItem().toString());

        return rota;
    }
}

