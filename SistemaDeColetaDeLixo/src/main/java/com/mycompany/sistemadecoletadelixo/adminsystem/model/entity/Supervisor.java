/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entity;

/**
 *
 * @author marce
 */
import javax.persistence.Entity;

@Entity
public class Supervisor extends Pessoa {
    
    private int idDepartamento;
    private String dataContrato;

    public Supervisor(){
        super();
        this.idDepartamento = -1;
        this.dataContrato = "00/00/0000";
    }
    
    public Supervisor(          
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
            String complemento){
        super(
            nome, 
            sexo, 
            dataNascimento, 
            cpf, 
            email,
            senha,
            telefone, 
            cep,
            rua,
            bairro,
            cidade,
            numero,
            complemento);
        this.idDepartamento = idDepartamento;
        this.dataContrato = dataContrato;
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getDataContrato(){
        return dataContrato;
    }
    
    public void setDataContrato(String dataContrato){
        this.dataContrato = dataContrato;
    }
}
