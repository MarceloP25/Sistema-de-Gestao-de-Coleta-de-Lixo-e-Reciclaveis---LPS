/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Supervisor extends Pessoa {
    
    @ManyToOne
    private Departamento departamento;
    
    private String dataContrato;
    private String idDepartamento;
    private String estacaoDescarga;
    private List<String> rotasSupervisionadas;
    private List<String> veiculosSupervisionados;

    public Supervisor(){
        super();
        this.departamento = new Departamento();
        this.dataContrato = "00/00/0000";
        this.estacaoDescarga = "";
        this.rotasSupervisionadas = null;
        this.veiculosSupervisionados = null;
        this.departamento = new Departamento();
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
            String complemento,
            Departamento departamento,
            String dataContrato){
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
        this.departamento = departamento;
        this.dataContrato = dataContrato;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(String dataContrato) {
        this.dataContrato = dataContrato;
    }


    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getEstacaoDescarga() {
        return estacaoDescarga;
    }

    public void setEstacaoDescarga(String estacaoDescarga) {
        this.estacaoDescarga = estacaoDescarga;
    }

    public List<String> getRotasSupervisionadas() {
        return rotasSupervisionadas;
    }

    public void setRotasSupervisionadas(List<String> rotasSupervisionadas) {
        this.rotasSupervisionadas = rotasSupervisionadas;
    }

    public List<String> getVeiculosSupervisionados() {
        return veiculosSupervisionados;
    }

    public void setVeiculosSupervisionados(List<String> veiculosSupervisionados) {
        this.veiculosSupervisionados = veiculosSupervisionados;
    }

}