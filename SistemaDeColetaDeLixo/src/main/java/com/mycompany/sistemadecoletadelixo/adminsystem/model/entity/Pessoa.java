package com.mycompany.sistemadecoletadelixo.adminsystem.model.entity;

/**
 *
 * @author marce
 */
import java.time.LocalDate;
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
public abstract class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nome;
    protected char sexo;
    protected LocalDate dataNascimento;
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
            LocalDate dataNascimento, 
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
    
    @Override
    public boolean equals(Object obj) {
        Pessoa outro = (Pessoa) obj;
        if(!this.nome.equals(outro.getNome()))
            return false;
        else if(this.email != outro.getEmail())
            return false;
        else if(this.cpf != outro.getCpf())
            return false;
        
        return true;
    }
    
    public void copiar(Pessoa outro) {
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.dataNascimento = outro.getDataNascimento();
        this.cpf = outro.getCpf();
        this.email = outro.getEmail();
        this.senha = outro.getSenha();
        this.telefone = outro.getTelefone();
        this.cep = outro.getCep();
        this.rua = outro.getRua();
        this.bairro = outro.getBairro();
        this.cidade = outro.getCidade();
        this.numero = outro.getNumero();
        this.complemento = outro.getComplemento();
    }
}
