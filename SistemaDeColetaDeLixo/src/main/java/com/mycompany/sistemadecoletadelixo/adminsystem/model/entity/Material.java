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
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

    @Column(name = "liberar_descarte")
    private String liberarDescarte;

    @Column(name = "instrucoes_descarte")
    private String instrucoesDescarte;

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

