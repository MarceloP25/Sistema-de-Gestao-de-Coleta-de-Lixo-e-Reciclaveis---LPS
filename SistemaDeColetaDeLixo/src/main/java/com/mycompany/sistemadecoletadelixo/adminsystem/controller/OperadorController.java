/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Operador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.OperadorDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateOperador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.OperadorException;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author eduhe
 */
public class OperadorController {

    private OperadorDAO repositorio;

    public OperadorController() {
        repositorio = new OperadorDAO();
    }

    public void cadastrarOperador(
            Long id, String nome, String dataNascimento, String cpf, String rua, String bairro, String cidade, 
            String numero, String complemento, String cep, String email, String senha,
            JComboBox<String> departamento, JComboBox<String> veiculo, JComboBox<String> rota) {

        ValidateOperador valid = new ValidateOperador();
        Operador novoOperador = valid.validaCamposEntrada( nome, dataNascimento, cpf, cep, rua, bairro, cidade, numero, complemento, email, senha, departamento, veiculo, rota);

        if (repositorio.find(id) == null) {
            repositorio.save(novoOperador);
        } else {
            throw new OperadorException("Error - Já existe um operador com este 'ID'.");
        }
    }

    public void atualizarOperador(
            Long id, String nome, String dataNascimento, String cpf, String rua, String bairro, String cidade,
            String numero, String complemento, String cep, String email, String senha,
            JComboBox<String> departamento, JComboBox<String> veiculo, JComboBox<String> rota) {

        ValidateOperador valid = new ValidateOperador();
        Operador operadorAtualizado = valid.validaCamposEntrada( nome, dataNascimento, cpf, cep, rua, bairro, cidade, numero, complemento, email, senha, departamento, veiculo, rota);operadorAtualizado.setId(id);

        repositorio.update(operadorAtualizado);
    }

    public Operador buscarOperador(Long id) {
        return this.repositorio.find(id);
    }

    public void excluirOperador(Long id) {
        Operador operador = repositorio.find(id);
        if (operador != null) {
            repositorio.delete(id);
        } else {
            throw new OperadorException("Error - Operador inexistente.");
        }
    }

    public String imprimirListaOperadores() {
        String listagemOperadores = "";

        for (Object obj : this.repositorio.findAll()) {
            Operador operador = (Operador) obj;
            listagemOperadores += operador.toString();
        }

        return listagemOperadores;
    }
}
