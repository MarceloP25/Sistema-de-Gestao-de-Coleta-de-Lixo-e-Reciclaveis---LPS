/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PontoDeColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomePonto;
    
    private String rua;
    
    private int numeroLixeiras;
    
    @ElementCollection
    private List<String> tiposLixo;

    public PontoDeColeta() {
        this.id = -1L;
        this.nomePonto = "";
        this.rua = "";
        this.numeroLixeiras = 0;
        this.tiposLixo = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePonto() {
        return nomePonto;
    }

    public void setNomePonto(String nomePonto) {
        this.nomePonto = nomePonto;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroLixeiras() {
        return numeroLixeiras;
    }

    public void setNumeroLixeiras(int numeroLixeiras) {
        this.numeroLixeiras = numeroLixeiras;
    }

    public List<String> getTiposLixo() {
        return tiposLixo;
    }

    public void setTiposLixo(List<String> tiposLixo) {
        this.tiposLixo = tiposLixo;
    }

    public void setNomeRota(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
