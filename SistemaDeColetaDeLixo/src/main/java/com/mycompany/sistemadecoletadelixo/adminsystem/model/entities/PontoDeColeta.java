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
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marce
 */
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class PontoDeColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomePonto;
    
    @ManyToOne
    private String rua;
    
    private int numeroLixeiras;
    private List<String> tiposLixo;
    
    public PontoDeColeta(){
        this.id = -1L;
        this.nomePonto = "";
        this.rua = "";
        this.numeroLixeiras = 0;
        this.tiposLixo = new ArrayList<>();
    }

}

