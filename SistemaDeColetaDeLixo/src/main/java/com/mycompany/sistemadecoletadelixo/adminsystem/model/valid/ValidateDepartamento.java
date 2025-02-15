/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.DepartamentoException;

/**
 *
 * @author Edu
 */
public class ValidateDepartamento {
    

    public Departamento validaCamposEntrada(String nome, String rua, String bairro, String cidade, 
                                            String numero, String complemento, String cep,
                                            String numEstacoesDescarga, String numOperadores, 
                                            String numSupervisores, String numVeiculos) {
        Departamento departamento = new Departamento();

        if (nome.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'nome'.");
        departamento.setNome(nome);

        if (rua.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'rua'.");
        departamento.setRua(rua);

        if (bairro.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'bairro'.");
        departamento.setBairro(bairro);

        if (cidade.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'cidade'.");
        departamento.setCidade(cidade);

        if (numero.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'número'.");
        if (!numero.matches("[0-9]*"))
            throw new DepartamentoException("Error - Valor inválido no campo 'número'.");
        departamento.setNumero(numero);

        if (complemento.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'complemento'.");
        departamento.setComplemento(complemento);

        if (cep.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'CEP'.");
        if (!cep.matches("\\d{5}-\\d{3}"))  // Formato esperado: 12345-678
            throw new DepartamentoException("Error - Formato inválido para o campo 'CEP'. Use o formato 12345-678.");
        departamento.setCep(cep);

        if (numEstacoesDescarga.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'número de estações de descarga'.");
        if (!numEstacoesDescarga.matches("[0-9]*"))
            throw new DepartamentoException("Error - Valor inválido no campo 'número de estações de descarga'.");
        departamento.setNumEstacoesDescarga(Integer.parseInt(numEstacoesDescarga));

        if (numOperadores.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'número de operadores'.");
        if (!numOperadores.matches("[0-9]*"))
            throw new DepartamentoException("Error - Valor inválido no campo 'número de operadores'.");
        departamento.setNumOperadores(Integer.parseInt(numOperadores));

        if (numSupervisores.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'número de supervisores'.");
        if (!numSupervisores.matches("[0-9]*"))
            throw new DepartamentoException("Error - Valor inválido no campo 'número de supervisores'.");
        departamento.setNumSupervisores(Integer.parseInt(numSupervisores));

        if (numVeiculos.isEmpty())
            throw new DepartamentoException("Error - Campo vazio: 'número de veículos'.");
        if (!numVeiculos.matches("[0-9]*"))
            throw new DepartamentoException("Error - Valor inválido no campo 'número de veículos'.");
        departamento.setNumVeiculos(Integer.parseInt(numVeiculos));

        return departamento;
    }
}

