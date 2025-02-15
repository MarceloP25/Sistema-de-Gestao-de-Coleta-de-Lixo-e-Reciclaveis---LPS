/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class EstacaoDescarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstacao;

    @ManyToMany(mappedBy = "estacoesDescarga")
    private List<Departamento> departamento;
    
    private String nomeEstacao;
    private float capacidadeMaxima;
    
    private String tipoMaterialAceito;
    
    private String statusOperacao;
    
    public EstacaoDescarga(){
        this.idEstacao = -1L;
        this.departamento = new ArrayList<>();
        this.capacidadeMaxima = 0;
        this.tipoMaterialAceito = "";
        this.statusOperacao = "Desativada";
    }
    
    public EstacaoDescarga(
            List<Departamento> departamento,
            float capacidadeMaxima,
            String tipoMaterialAceito,
            String statusOperacao
            ){
        this.departamento = departamento;
        this.capacidadeMaxima = capacidadeMaxima;
        this.tipoMaterialAceito = tipoMaterialAceito;
        this.statusOperacao = statusOperacao;
    }

    public Long getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Long idEstacao) {
        this.idEstacao = idEstacao;
    }

    public List<Departamento> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<Departamento> departamento) {
        this.departamento = departamento;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public float getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(float capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getTipoMaterialAceito() {
        return tipoMaterialAceito;
    }

    public void setTipoMaterialAceito(String tipoMaterialAceito) {
        this.tipoMaterialAceito = tipoMaterialAceito;
    }

    public String getStatusOperacao() {
        return statusOperacao;
    }

    public void setStatusOperacao(String statusOperacao) {
        this.statusOperacao = statusOperacao;
    }
}
