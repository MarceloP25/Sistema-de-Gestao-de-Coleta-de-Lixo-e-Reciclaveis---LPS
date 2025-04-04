package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.EstacaoDescarga;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.EstacaoDescargaDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateEstacaoDescarga;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.EstacaoDescargaException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class EstacaoDescargaController {

    private EstacaoDescargaDAO repositorio;

    public EstacaoDescargaController() {
        repositorio = new EstacaoDescargaDAO();
    }

    public void cadastrarEstacaoDescarga(
            Long id, 
            String nome, 
            String capacidadeProcessamento, 
            JComboBox<String> supervisorMaquinario,
            JComboBox<String> departamento, 
            JCheckBox[] materiaisProcessamento) {

        ValidateEstacaoDescarga valid = new ValidateEstacaoDescarga();
        EstacaoDescarga novaEstacaoDescarga = valid.validaCamposEntrada(nome, capacidadeProcessamento, supervisorMaquinario, departamento, materiaisProcessamento);

        if (repositorio.find(id) == null) {
            novaEstacaoDescarga.setIdEstacao(id);
            repositorio.save(novaEstacaoDescarga);
        } else {
            throw new EstacaoDescargaException("Error - Já existe uma estação de descarga com este 'ID'.");
        }
    }

    public void atualizarEstacaoDescarga(
            Long id, 
            String nome, 
            String capacidadeProcessamento, 
            JComboBox<String> supervisorMaquinario,
            JComboBox<String> departamento, 
            JCheckBox[] materiaisProcessamento) {

        ValidateEstacaoDescarga valid = new ValidateEstacaoDescarga();
        EstacaoDescarga estacaoAtualizada = valid.validaCamposEntrada(nome, capacidadeProcessamento, supervisorMaquinario, departamento, materiaisProcessamento);
        estacaoAtualizada.setIdEstacao(id);

        repositorio.update(estacaoAtualizada);
    }

    public EstacaoDescarga buscarEstacaoDescarga(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirEstacaoDescarga(Long id) {
        EstacaoDescarga estacaoDescarga = repositorio.find(id);
        if (estacaoDescarga != null) {
            repositorio.delete(id);
        } else {
            throw new EstacaoDescargaException("Error - Estação de descarga inexistente.");
        }
    }

    public String imprimirListaEstacoesDescarga() {
        StringBuilder listagemEstacoes = new StringBuilder();
        for (Object obj : this.repositorio.findAll()) {
            EstacaoDescarga estacaoDescarga = (EstacaoDescarga) obj;
            listagemEstacoes.append(estacaoDescarga.toString()).append("\n");
        }
        return listagemEstacoes.toString();
    }
}