package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Cidadao;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.CidadaoException;

public class ValidateCidadao {

    public Cidadao validacao(long id,
                             String nome,
                             String dataNascimento,
                             String cpf,
                             String email,
                             String cep,
                             String rua,
                             String bairro,
                             String cidade,
                             String numero,
                             String complemento,
                             String telefone) {
        Cidadao cidadao = new Cidadao();

        // Define o ID
        cidadao.setId(id);

        // Validação do nome
        if (nome == null || nome.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'nome'.");
        }
        cidadao.setNome(nome);

        // Validação da data de nascimento
        if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'dataNascimento'.");
        }
        cidadao.setDataNascimento(dataNascimento);

        // Validação do CPF
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'cpf'.");
        }
        // Integração com o validador de CPF
        ValidatePessoaFisica cpfValidator = new ValidatePessoaFisica();
        if (!cpfValidator.validaCPF(cpf)) {
            throw new CidadaoException("Error - CPF inválido.");
        }
        cidadao.setCpf(cpf);

        // Validação do email
        if (email == null || email.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'email'.");
        }
        cidadao.setEmail(email);

        // Validação do CEP
        if (cep == null || cep.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'cep'.");
        }
        cidadao.setCep(cep);

        // Validação da rua
        if (rua == null || rua.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'rua'.");
        }
        cidadao.setRua(rua);

        // Validação do bairro
        if (bairro == null || bairro.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'bairro'.");
        }
        cidadao.setBairro(bairro);

        // Validação da cidade
        if (cidade == null || cidade.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'cidade'.");
        }
        cidadao.setCidade(cidade);

        // Validação do número
        if (numero == null || numero.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'numero'.");
        }
        cidadao.setNumero(numero);

        // Complemento (pode ser opcional)
        cidadao.setComplemento(complemento == null ? "" : complemento);

        // Validação do telefone
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new CidadaoException("Error - Campo vazio: 'telefone'.");
        }
        cidadao.setTelefone(telefone);

        return cidadao;
    }
}
