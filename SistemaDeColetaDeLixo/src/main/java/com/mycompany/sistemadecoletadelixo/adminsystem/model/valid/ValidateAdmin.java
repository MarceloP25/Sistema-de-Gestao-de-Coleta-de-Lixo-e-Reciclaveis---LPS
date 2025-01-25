/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;

import com.mycompany.sistemadecoletadelixo.adminsystem.Admin;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.AdminException;

/**
 *
 * @author Edu
 */
public class ValidateAdmin {

    public Admin validaCamposEntrada(String nome, String dataNascimento, String rua, String bairro, String cidade,
                                     String numero, String complemento, String cep, String email, String senha) {
        Admin admin = new Admin();

        if (nome.isEmpty())
            throw new AdminException("Error - Campo vazio: 'nome'.");
        admin.setNome(nome);

        if (dataNascimento.isEmpty())
            throw new AdminException("Error - Campo vazio: 'data de nascimento'.");
        if (!dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}"))  // Formato esperado: DD/MM/AAAA
            throw new AdminException("Error - Formato inválido para o campo 'data de nascimento'. Use o formato DD/MM/AAAA.");
        admin.setDataNascimento(dataNascimento);

        if (rua.isEmpty())
            throw new AdminException("Error - Campo vazio: 'rua'.");
        admin.setRua(rua);

        if (bairro.isEmpty())
            throw new AdminException("Error - Campo vazio: 'bairro'.");
        admin.setBairro(bairro);

        if (cidade.isEmpty())
            throw new AdminException("Error - Campo vazio: 'cidade'.");
        admin.setCidade(cidade);

        if (numero.isEmpty())
            throw new AdminException("Error - Campo vazio: 'número'.");
        if (!numero.matches("[0-9]*"))
            throw new AdminException("Error - Valor inválido no campo 'número'.");
        admin.setNumero(Integer.parseInt(numero));

        if (complemento.isEmpty())
            throw new AdminException("Error - Campo vazio: 'complemento'.");
        admin.setComplemento(complemento);

        if (cep.isEmpty())
            throw new AdminException("Error - Campo vazio: 'CEP'.");
        if (!cep.matches("\\d{5}-\\d{3}"))  // Formato esperado: 12345-678
            throw new AdminException("Error - Formato inválido para o campo 'CEP'. Use o formato 12345-678.");
        admin.setCep(cep);

        if (email.isEmpty())
            throw new AdminException("Error - Campo vazio: 'email'.");
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) // Validação básica de email
            throw new AdminException("Error - Formato inválido para o campo 'email'.");
        admin.setEmail(email);

        if (senha.isEmpty())
            throw new AdminException("Error - Campo vazio: 'senha'.");
        if (senha.length() < 6)
            throw new AdminException("Error - O campo 'senha' deve ter pelo menos 6 caracteres.");
        admin.setSenha(senha);

        return admin;
    }
}
