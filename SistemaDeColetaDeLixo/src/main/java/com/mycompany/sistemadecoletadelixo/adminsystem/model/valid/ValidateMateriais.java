/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Material;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.MaterialException;
import javax.swing.JRadioButton;
/**
 *
 * @author Edu
 */
public class ValidateMateriais {

    public Material validaCamposEntrada(String nome, JRadioButton[] tipos, JRadioButton[] lixeiras, String descricao) {
        Material material = new Material();

        // Validação do Nome
        if (nome.isEmpty())
            throw new MaterialException("Error - Campo vazio: 'nome do material'.");
        material.setNome(nome);

        // Validação do Tipo (JRadioButtons)
        boolean tipoSelecionado = false;
        String tipoEscolhido = "";
        for (JRadioButton tipo : tipos) {
            if (tipo.isSelected()) {
                tipoSelecionado = true;
                tipoEscolhido = tipo.getText();
                break; // Apenas um tipo deve ser selecionado
            }
        }
        if (!tipoSelecionado)
            throw new MaterialException("Error - Nenhum tipo de material selecionado.");
        material.setTipo(tipoEscolhido);

        // Validação da Lixeira para Descarte Correto (JRadioButtons)
        boolean lixeiraSelecionada = false;
        String lixeiraEscolhida = "";
        for (JRadioButton lixeira : lixeiras) {
            if (lixeira.isSelected()) {
                lixeiraSelecionada = true;
                lixeiraEscolhida = lixeira.getText();
                break; // Apenas uma lixeira deve ser selecionada
            }
        }
        if (!lixeiraSelecionada)
            throw new MaterialException("Error - Nenhuma lixeira selecionada para o descarte correto.");
        material.setLixeiraParaDescarte(lixeiraEscolhida);

        // Validação da Descrição para Descarte
        if (descricao.isEmpty())
            throw new MaterialException("Error - Campo vazio: 'descrição para descarte'.");
        material.setDescricaoParaDescarte(descricao);

        return material;
    }
}

