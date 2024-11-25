/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entity;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "coleta")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supervisor;
    private Float peso;

    @Column(name = "materiais_coletados")
    private String materiaisColetados;

    private Long operador;
    private Long rota;
    private Long veiculo;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getMateriaisColetados() {
        return materiaisColetados;
    }

    public void setMateriaisColetados(String materiaisColetados) {
        this.materiaisColetados = materiaisColetados;
    }

    public Long getOperador() {
        return operador;
    }

    public void setOperador(Long operador) {
        this.operador = operador;
    }

    public Long getRota() {
        return rota;
    }

    public void setRota(Long rota) {
        this.rota = rota;
    }

    public Long getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Long veiculo) {
        this.veiculo = veiculo;
    }
}

