/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
package com.seuprojeto.modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "numero_estacoes_descarga", nullable = false)
    private Integer numeroEstacoesDescarga;

    @Column(name = "numero_veiculos", nullable = false)
    private Integer numeroVeiculos;

    @Column(name = "numero_supervisores", nullable = false)
    private Integer numeroSupervisores;

    @Column(name = "numero_operadores", nullable = false)
    private Integer numeroOperadores;

    // Construtores
    public Departamento() {}

    public Departamento(String nome, String rua, String bairro, String cidade, Integer numero, String complemento, String cep, 
                        Integer numeroEstacoesDescarga, Integer numeroVeiculos, Integer numeroSupervisores, Integer numeroOperadores) {
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.numeroEstacoesDescarga = numeroEstacoesDescarga;
        this.numeroVeiculos = numeroVeiculos;
        this.numeroSupervisores = numeroSupervisores;
        this.numeroOperadores = numeroOperadores;
    }

    // Getters e Setters
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumeroEstacoesDescarga() {
        return numeroEstacoesDescarga;
    }

    public void setNumeroEstacoesDescarga(Integer numeroEstacoesDescarga) {
        this.numeroEstacoesDescarga = numeroEstacoesDescarga;
    }

    public Integer getNumeroVeiculos() {
        return numeroVeiculos;
    }

    public void setNumeroVeiculos(Integer numeroVeiculos) {
        this.numeroVeiculos = numeroVeiculos;
    }

    public Integer getNumeroSupervisores() {
        return numeroSupervisores;
    }

    public void setNumeroSupervisores(Integer numeroSupervisores) {
        this.numeroSupervisores = numeroSupervisores;
    }

    public Integer getNumeroOperadores() {
        return numeroOperadores;
    }

    public void setNumeroOperadores(Integer numeroOperadores) {
        this.numeroOperadores = numeroOperadores;
    }
}
