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
            String id,
            String nome,
            String tipo,
            String lixeiraDescarte,
            String instrucoesDescarte) {

        ValidateMaterial valid = new ValidateMaterial();
        Material novoMaterial = valid.validacao(id, nome, tipo, lixeiraDescarte, instrucoesDescarte);

        if (repositorio.findById(id) == null) {
            repositorio.save(novoMaterial);
        } else {
            throw new MaterialException("Error - Já existe um material com este 'ID'.");
        }
    }

    public void atualizarMaterial(
            String idOriginal,
            String id,
            String nome,
            String tipo,
            String lixeiraDescarte,
            String instrucoesDescarte) {

        ValidateMaterial valid = new ValidateMaterial();
        Material materialAtualizado = valid.validacao(id, nome, tipo, lixeiraDescarte, instrucoesDescarte);
        materialAtualizado.setId(idOriginal);

        repositorio.update(materialAtualizado);
    }

    public Material buscarMaterial(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirMaterial(String id) {
        Material material = repositorio.findById(id);
        if (material != null) {
            repositorio.delete(material);
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
