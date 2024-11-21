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
@Table(name = "supervisor")
public class Supervisor extends Pessoa {
    @Column(name = "setor_responsavel", nullable = false)
    private String setorResponsavel;

    // Getters e Setters
    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }
}
