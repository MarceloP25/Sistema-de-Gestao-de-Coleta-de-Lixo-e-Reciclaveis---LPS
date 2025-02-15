package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Administrador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.AdministradorException;

public class ValidateAdministrador {

    public Administrador validaCamposEntrada(
            String nome, String dataNascimento, String rua, String bairro, 
            String cidade, String numero, String complemento, String cep, 
            String email, String senha, String cpf, String telefone) {

        Administrador admin = new Administrador();

        if (nome == null || nome.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'nome'.");
        admin.setNome(nome);

        if (dataNascimento == null || dataNascimento.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'data de nascimento'.");
        if (!dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}"))  
            throw new AdministradorException("Error - Formato inválido para 'data de nascimento'. Use DD/MM/AAAA.");
        admin.setDataNascimento(dataNascimento);

        if (rua == null || rua.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'rua'.");
        admin.setRua(rua);

        if (bairro == null || bairro.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'bairro'.");
        admin.setBairro(bairro);

        if (cidade == null || cidade.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'cidade'.");
        admin.setCidade(cidade);

        if (numero == null || numero.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'número'.");
        if (!numero.matches("\\d+"))  
            throw new AdministradorException("Error - O campo 'número' deve conter apenas números.");
        admin.setNumero(numero);

        if (complemento != null) 
            admin.setComplemento(complemento);

        if (cep == null || cep.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'CEP'.");
        if (!cep.matches("\\d{5}-\\d{3}"))  
            throw new AdministradorException("Error - Formato inválido para 'CEP'. Use 12345-678.");
        admin.setCep(cep);

        if (email == null || email.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'email'.");
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) 
            throw new AdministradorException("Error - Formato inválido para 'email'.");
        admin.setEmail(email);

        if (senha == null || senha.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'senha'.");
        if (senha.length() < 6) 
            throw new AdministradorException("Error - O campo 'senha' deve ter pelo menos 6 caracteres.");
        admin.setSenha(senha);

        if (cpf == null || cpf.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'CPF'.");
        if (!cpf.matches("\\d{11}"))  
            throw new AdministradorException("Error - Formato inválido para 'CPF'. Deve conter 11 dígitos numéricos.");
        admin.setCpf(cpf);

        if (telefone == null || telefone.trim().isEmpty()) 
            throw new AdministradorException("Error - Campo vazio: 'telefone'.");
        if (!telefone.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}"))  
            throw new AdministradorException("Error - Formato inválido para 'telefone'. Use (XX)XXXXX-XXXX.");
        admin.setTelefone(telefone);

        return admin;
    }

    
}
