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
@Table(name = "operador")
public class Operador extends Pessoa {
    @Column(name = "turno_trabalho", nullable = false)
    private String turnoTrabalho;

    @Column(name = "veiculo_alocado")
    private String veiculoAlocado;

    // Getters e Setters
    public String getTurnoTrabalho() {
        return turnoTrabalho;
    }

    public void setTurnoTrabalho(String turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }

    public String getVeiculoAlocado() {
        return veiculoAlocado;
    }

    public void setVeiculoAlocado(String veiculoAlocado) {
        this.veiculoAlocado = veiculoAlocado;
    }
}

