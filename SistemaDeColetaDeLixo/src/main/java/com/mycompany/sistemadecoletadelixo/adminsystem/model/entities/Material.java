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
import javax.swing.JRadioButton;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private List<String> tipos;  
    private List<String> lixeiras;  
    private String descricao;
    
    public Material() {
        this.id = -1L;
        this.nome = "";
        this.tipos = new ArrayList<>();  
        this.lixeiras = new ArrayList<>(); 
        this.descricao = "";
    }
    
    public Material(
            String nome,
            List<String> tipos,
            List<String> lixeiras,
            String descricao
        ){
        this.nome = nome;
        this.tipos = tipos != null ? tipos : new ArrayList<>();
        this.lixeiras = lixeiras != null ? lixeiras : new ArrayList<>();
        this.descricao = descricao;
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

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public List<String> getLixeiras() {
        return lixeiras;
    }

    public void setLixeiras(List<String> lixeiras) {
        this.lixeiras = lixeiras;
    }

    public String getDescricaoDescarte() {
        return descricao;
    }

    public void setDescricaoDescarte(String descricao) {
        this.descricao = descricao;
    }

    public void setLixeiraParaDescarte(String lixeiraEscolhida) {
        if (!lixeiras.contains(lixeiraEscolhida)) {
            lixeiras.add(lixeiraEscolhida);
        }
    }
}

