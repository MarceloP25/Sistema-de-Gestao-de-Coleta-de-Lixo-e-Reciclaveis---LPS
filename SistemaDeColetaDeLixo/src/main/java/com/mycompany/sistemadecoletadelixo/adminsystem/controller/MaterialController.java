/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Material;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.MaterialDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateMaterial;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.MaterialException;
import javax.swing.JRadioButton;

/**
 *
 * @author eduhe
 */
public class MaterialController {

    private MaterialDAO repositorio;

    public MaterialController() {
        repositorio = new MaterialDAO();
    }

    public void cadastrarMaterial(
            Long id, String nome, JRadioButton[] tipos, JRadioButton[] lixeiras, String descricao) {

        ValidateMaterial valid = new ValidateMaterial();
        Material novoMaterial = valid.validaCamposEntrada( nome, tipos, lixeiras, descricao);

        if (repositorio.find(id) == null) {
            repositorio.save(novoMaterial);
        } else {
            throw new MaterialException("Error - Já existe um material com este 'ID'.");
        }
    }

    public void atualizarMaterial(
            Long id, String nome, JRadioButton[] tipos, JRadioButton[] lixeiras, String descricao) {

        ValidateMaterial valid = new ValidateMaterial();
        Material materialAtualizado = valid.validaCamposEntrada(nome, tipos, lixeiras, descricao);
        materialAtualizado.setId(id);

        repositorio.update(materialAtualizado);
    }

    public Material buscarMaterial(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirMaterial(Long id) {
        Material material = repositorio.find(id);
        if (material != null) {
            repositorio.delete(id);
        } else {
            throw new MaterialException("Error - Material inexistente.");
        }
    }

    public String imprimirListaMateriais() {
        String listagemMateriais = "";

        for (Object obj : this.repositorio.findAll()) {
            Material material = (Material) obj;
            listagemMateriais += material.toString();
        }

        return listagemMateriais;
    }
}
