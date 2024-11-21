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
@Table(name = "administrador")
public class Administrador extends Pessoa {
    @Column(name = "id_departamento")
    private Long idDepartamento;

    // Getters e Setters
    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}


