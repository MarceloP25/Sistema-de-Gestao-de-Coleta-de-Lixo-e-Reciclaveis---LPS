/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entity;

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

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String complemento;
    private String cep;
    
    @ManyToOne
    private Administrador administrador;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "estacao_id")
    )
    private List<EstacaoDescarga> estacoesDescarga;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "veiculo_id")
    )
    private List<Veiculo> veiculos;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "supervisor_id")
    )
    private List<Supervisor> supervisores;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "operador_id")
    )
    private List<Operador> operadores;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "rota_id")
    )
    private List<Rota> rotas;

    public Departamento() {
        this.id = -1L;
        this.nome = "";
        this.cep = "00000-000";
        this.rua = "";
        this.bairro = "";
        this.cidade = "";
        this.numero = "";
        this.complemento = "";
        this.administrador = new Administrador();
        this.estacoesDescarga = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.supervisores = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.rotas = new ArrayList<>();
    }

   public Departamento(
           String nome,
           String cep,
           String rua,
           String bairro,
           String cidade,
           String numero,
           String complemento,
           
   ){
   
   }
}
