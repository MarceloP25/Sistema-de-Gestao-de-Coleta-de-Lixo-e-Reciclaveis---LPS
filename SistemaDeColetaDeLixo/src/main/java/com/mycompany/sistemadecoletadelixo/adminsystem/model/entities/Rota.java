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
    
    private List<String> ruas;
    
    @OneToMany(mappedBy = "rua")
    private List<PontoDeColeta> pontosColeta;

    private Supervisor responsavelRota;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "rota_id"),
        inverseJoinColumns = @JoinColumn(name = "motorista_id")
    )
    private List<Operador> operador;
    
    private String statusRota;

    public Rota(){
        this.id = -1L;
        this.nomeRota = "";
        this.ruas = new ArrayList<>();
        this.pontosColeta = new ArrayList<>();
        this.responsavelRota = new Supervisor();
        this.operador = new ArrayList<>();
        this.statusRota = "Desativada";
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

    public List<String> getRuas() {
        return ruas;
    }

    public void setRuas(List<String> ruas) {
        this.ruas = ruas;
    }

    public List<PontoDeColeta> getPontosColeta() {
        return pontosColeta;
    }

    public void setPontosColeta(List<PontoDeColeta> pontosColeta) {
        this.pontosColeta = pontosColeta;
    }

    public Supervisor getResponsavelRota() {
        return responsavelRota;
    }

    public void setResponsavelRota(Supervisor responsavelRota) {
        this.responsavelRota = responsavelRota;
    }

    public List<Operador> getOperador() {
        return operador;
    }

    public void setOperador(List<Operador> operador) {
        this.operador = operador;
    }

    public String getStatusRota() {
        return statusRota;
    }

    public void setStatusRota(String statusRota) {
        this.statusRota = statusRota;
    }
}
