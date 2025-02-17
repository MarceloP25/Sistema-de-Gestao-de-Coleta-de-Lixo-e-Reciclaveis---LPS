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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRota;
    private String ruaInicio;
    private String ruaFim;

    @ElementCollection
    private List<String> ruasPercorridas;

    private String departamento; // Agora é String
    private String supervisor;   // Agora é String

    public Rota() {
        this.id = -1L;
        this.nomeRota = "";
        this.ruaInicio = "";
        this.ruaFim = "";
        this.ruasPercorridas = new ArrayList<>();
        this.departamento = "";
        this.supervisor = "";
    }

    // Getters e Setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public void setNomeRota(String nomeRota) {
        this.nomeRota = nomeRota;
    }

    public String getRuaInicio() {
        return ruaInicio;
    }

    public void setRuaInicio(String ruaInicio) {
        this.ruaInicio = ruaInicio;
    }

    public String getRuaFim() {
        return ruaFim;
    }

    public void setRuaFim(String ruaFim) {
        this.ruaFim = ruaFim;
    }

    public List<String> getRuasPercorridas() {
        return ruasPercorridas;
    }

    public void setRuasPercorridas(List<String> ruasPercorridas) {
        this.ruasPercorridas = ruasPercorridas;
    }
}
