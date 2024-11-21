/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.classes;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "ponto_coleta")
public class PontoDeColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;

    @Column(name = "numero_lixeiras")
    private Integer numeroLixeiras;

    @Column(name = "tipos_lixo")
    private String tiposLixo;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getNumeroLixeiras() {
        return numeroLixeiras;
    }

    public void setNumeroLixeiras(Integer numeroLixeiras) {
        this.numeroLixeiras = numeroLixeiras;
    }

    public String getTiposLixo() {
        return tiposLixo;
    }

    public void setTiposLixo(String tiposLixo) {
        this.tiposLixo = tiposLixo;
    }
}

