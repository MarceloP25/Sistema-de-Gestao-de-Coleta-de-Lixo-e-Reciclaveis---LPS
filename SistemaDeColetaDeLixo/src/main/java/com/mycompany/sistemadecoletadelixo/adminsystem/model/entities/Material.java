/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String liberarDescarte;
    private String instrucoesDescarte;
    
    public Material(){
        this.id = -1L;
        this.nome = "";
        this.tipo = "";
        this.liberarDescarte = "";
        this.instrucoesDescarte = "";
    }
    
    public Material(
            String nome,
            String tipo,
            String liberarDescarte,
            String instrucoesDescarte
        ){
        this.nome = nome;
        this.tipo = tipo;
        this.liberarDescarte = liberarDescarte;
        this.instrucoesDescarte = instrucoesDescarte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLiberarDescarte() {
        return liberarDescarte;
    }

    public void setLiberarDescarte(String liberarDescarte) {
        this.liberarDescarte = liberarDescarte;
    }

    public String getInstrucoesDescarte() {
        return instrucoesDescarte;
    }

    public void setInstrucoesDescarte(String instrucoesDescarte) {
        this.instrucoesDescarte = instrucoesDescarte;
    }
}
