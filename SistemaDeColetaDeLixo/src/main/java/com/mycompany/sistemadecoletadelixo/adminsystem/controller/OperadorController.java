/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Operador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO.OperadorDAO;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.valid.ValidateOperador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.OperadorException;

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
            String id,
            String nome,
            String dataNascimento,
            String cpfCnpj,
            String email,
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String telefone,
            String dataContrato,
            String idDepartamento,
            List<String> rotasAssociadas,
            List<String> veiculosUtilizados,
            String estacaoDescarga) {

        ValidateOperador valid = new ValidateOperador();
        Operador novoOperador = valid.validacao(id, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento, telefone, dataContrato, idDepartamento, rotasAssociadas, veiculosUtilizados, estacaoDescarga);

        if (repositorio.findById(id) == null) {
            repositorio.save(novoOperador);
        } else {
            throw new OperadorException("Error - Já existe um operador com este 'ID'.");
        }
    }

    public void atualizarOperador(
            String idOriginal,
            String id,
            String nome,
            String dataNascimento,
            String cpfCnpj,
            String email,
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            String telefone,
            String dataContrato,
            String idDepartamento,
            List<String> rotasAssociadas,
            List<String> veiculosUtilizados,
            String estacaoDescarga) {

        ValidateOperador valid = new ValidateOperador();
        Operador operadorAtualizado = valid.validacao(id, nome, dataNascimento, cpfCnpj, email, cep, rua, bairro, cidade, numero, complemento, telefone, dataContrato, idDepartamento, rotasAssociadas, veiculosUtilizados, estacaoDescarga);
        operadorAtualizado.setId(idOriginal);

        repositorio.update(operadorAtualizado);
    }

    public Operador buscarOperador(String id) {
        return this.repositorio.findById(id);
    }

    public void excluirOperador(String id) {
        Operador operador = repositorio.findById(id);
        if (operador != null) {
            repositorio.delete(operador);
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
