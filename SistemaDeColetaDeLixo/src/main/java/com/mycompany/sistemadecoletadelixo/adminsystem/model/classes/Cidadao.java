/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.classes;

/**
 *
 * @author marce
 */
import jakarta.persistence.*;

@Entity
@Table(name = "cidadao")
public class Cidadao extends Pessoa {
    @Column(name = "numero_casa")
    private String numeroCasa;

    @Column(name = "tipo_residencia")
    private String tipoResidencia;

    @Column(name = "bairro_residencia")
    private String bairroResidencia;

    @Column(name = "cidade_residencia")
    private String cidadeResidencia;

    // Getters e Setters
    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public String getBairroResidencia() {
        return bairroResidencia;
    }

    public void setBairroResidencia(String bairroResidencia) {
        this.bairroResidencia = bairroResidencia;
    }

    public String getCidadeResidencia() {
        return cidadeResidencia;
    }

    public void setCidadeResidencia(String cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }
}
    
