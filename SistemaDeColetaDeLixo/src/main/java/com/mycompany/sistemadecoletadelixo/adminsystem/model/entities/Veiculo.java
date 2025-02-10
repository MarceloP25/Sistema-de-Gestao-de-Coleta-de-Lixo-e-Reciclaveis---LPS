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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String chassi;
    private String modelo;
    private float consumoPorKm;
    private int eixos;
    private float comprimento;
    private float altura;
    private float largura;
    private char carteiraConducao;
    private float carga;
    private String combustivel;
    private String dataManutencao;
    
    @ManyToOne
    private Departamento departamento;
    
    @ManyToMany(mappedBy = "veiculos")
    private List<Operador> operador;
    
    public Veiculo(){
        this.id = -1L;
        this.placa = "";
        this.chassi = "";
        this.modelo = "";
        this.consumoPorKm = 0;
        this.eixos = 0;
        this.comprimento = 0;
        this.altura = 0;
        this.largura = 0;
        this.carteiraConducao = ' ';
        this.carga = 0;
        this.combustivel = "";
        this.dataManutencao = "00/00/0000";
        this.departamento = new Departamento();
        this.operador = new ArrayList<>();
    }
    
    public Veiculo(
            String placa,
            String chassi,
            String modelo,
            float consumoPorKm,
            int eixos,
            float comprimento,
            float altura,
            float largura,
            char carteiraConducao,
            float carga,
            String combustivel,
            String dataManutencao,
            Departamento departamento,
            List operador
        ){
        this.placa = placa;
        this.chassi = chassi;
        this.modelo = modelo;
        this.consumoPorKm = consumoPorKm;
        this.eixos = eixos;
        this.comprimento = comprimento;
        this.altura = altura;
        this.largura = largura;
        this.carteiraConducao = carteiraConducao;
        this.carga = carga;
        this.combustivel = combustivel;
        this.dataManutencao = dataManutencao;
        this.departamento = departamento;
        this.operador = operador; 
    }

}
