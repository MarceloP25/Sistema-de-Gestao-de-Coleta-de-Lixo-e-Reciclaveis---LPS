/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rota")
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_rota")
    private String nomeRota;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "pontos_coleta")
    private String pontosColeta;

    @Column(name = "veiculos_alocados")
    private String veiculosAlocados;

    @Column(name = "responsavel_rota")
    private String responsavelRota;

    @Column(name = "status_rota")
    private String statusRota; // Exemplo: "Ativa", "Inativa", "Concluída".

    // Getters e Setters
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getPontosColeta() {
        return pontosColeta;
    }

    public void setPontosColeta(String pontosColeta) {
        this.pontosColeta = pontosColeta;
    }

    public String getVeiculosAlocados() {
        return veiculosAlocados;
    }

    public void setVeiculosAlocados(String veiculosAlocados) {
        this.veiculosAlocados = veiculosAlocados;
    }

    public String getResponsavelRota() {
        return responsavelRota;
    }

    public void setResponsavelRota(String responsavelRota) {
        this.responsavelRota = responsavelRota;
    }

    public String getStatusRota() {
        return statusRota;
    }

    public void setStatusRota(String statusRota) {
        this.statusRota = statusRota;
    }
}

