package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nome;
    protected char sexo;
    protected String dataNascimento;
    protected String cpf;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String cep;
    protected String rua;
    protected String bairro;
    protected String cidade;
    protected String numero;
    protected String complemento;

    public Pessoa(){
        this.id = -1L;
        this.nome = "";
        this.sexo = '-';
        this.dataNascimento = "00/00/0000";
        this.cpf = "000.000.000-00";
        this.email = "user@email.com";
        this.senha = "123456789";
        this.telefone = "(00)00000-0000";
        this.cep = "00000-000";
        this.rua = "";
        this.bairro = "";
        this.cidade = "";
        this.numero = "";
        this.complemento = "";
    }
    
    public Pessoa(
            String nome, 
            char sexo,
            String dataNascimento, 
            String cpf, 
            String email,
            String senha,
            String telefone, 
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento
            ){
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
    }
    
}
