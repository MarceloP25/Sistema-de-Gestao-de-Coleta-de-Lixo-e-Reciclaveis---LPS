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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    private float emissaoPoluentes;
    
    @ManyToOne
    private Departamento departamento;
    
    @ManyToMany(mappedBy = "veiculos")
    private List<Operador> operador;

}
