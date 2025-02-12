/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
=======
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
>>>>>>> Stashed changes
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class EstacaoDescarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstacao;

    @ManyToMany(mappedBy = "estacoesDescarga")
    private List<Departamento> departamento;
    
    private String nomeEstacao;
    private float capacidadeMaxima;
    
    private String tipoMaterialAceito;
    
    private String statusOperacao;
    
    public EstacaoDescarga(){
        this.idEstacao = -1L;
        this.departamento = new ArrayList<>();
        this.capacidadeMaxima = 0;
        this.tipoMaterialAceito = "";
        this.statusOperacao = "Desativada";
    }
    
    public EstacaoDescarga(
            List departamento,
            float capacidadeMaxima,
            String tipoMaterialAceito,
            String statusOperacao
            ){
        this.departamento = departamento;
        this.capacidadeMaxima = capacidadeMaxima;
        this.tipoMaterialAceito = tipoMaterialAceito;
        this.statusOperacao = statusOperacao;
    }

}

