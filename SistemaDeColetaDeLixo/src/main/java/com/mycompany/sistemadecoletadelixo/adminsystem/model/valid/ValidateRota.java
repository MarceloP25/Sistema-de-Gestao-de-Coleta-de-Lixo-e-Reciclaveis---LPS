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

        if (nomeRota == null || nomeRota.isEmpty()) {
            throw new RotaException("Error - Campo vazio: 'nome da rota'.");
        }
        rota.setNomeRota(nomeRota);

        if (ruaInicio == null || ruaInicio.isEmpty()) {
            throw new RotaException("Error - Campo vazio: 'rua de início'.");
        }
        rota.setRuaInicio(ruaInicio);

        if (ruaFim == null || ruaFim.isEmpty()) {
            throw new RotaException("Error - Campo vazio: 'rua de fim'.");
        }
        rota.setRuaFim(ruaFim);

        if (ruasPercorridas == null || ruasPercorridas.isEmpty()) {
            throw new RotaException("Error - Nenhuma rua foi adicionada à rota.");
        }
        rota.setRuasPercorridas(ruasPercorridas);

        if (departamento.getSelectedItem() == null || departamento.getSelectedItem().toString().isEmpty()) {
            throw new RotaException("Error - Nenhum departamento selecionado.");
        }
        rota.setDepartamento(departamento.getSelectedItem().toString());

        if (supervisor.getSelectedItem() == null || supervisor.getSelectedItem().toString().isEmpty()) {
            throw new RotaException("Error - Nenhum supervisor selecionado.");
        }
        rota.setSupervisor(supervisor.getSelectedItem().toString());

        return rota;
    }
}

