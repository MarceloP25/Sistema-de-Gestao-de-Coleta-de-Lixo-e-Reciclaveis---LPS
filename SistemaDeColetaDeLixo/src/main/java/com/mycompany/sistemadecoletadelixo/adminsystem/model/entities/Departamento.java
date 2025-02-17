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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Departamento {

     private List<Departamento> departamento;
    
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
    name = "departamento_estacao_descarga",
    joinColumns = @JoinColumn(name = "departamento_id"),
    inverseJoinColumns = @JoinColumn(name = "estacao_descarga_id")
)
private List<EstacaoDescarga> estacoesDescarga = new ArrayList<>();
    
    @OneToMany(mappedBy = "departamento")
    private List<Veiculo> veiculos;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "supervisor_id")
    )
    private List<Supervisor> supervisores;
    
    @OneToMany(mappedBy = "departamento")
    private List<Operador> operadores;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "rota_id")
    )
    private List<Rota> rotas;
    
    @OneToMany(mappedBy = "departamento")
    private List<Coleta> coletas;
    
    public List<Departamento> getNomeDepartamento(){
     return this.departamento;
}
    public List<Operador> getOperadores() {
    return this.operadores;
    }
    public List<Supervisor> getSupervisores(){
    return this.supervisores;
    }
    public List<Coleta> getColetas(){
    return this.coletas;
}
    public List<Veiculo> getVeiculos(){
    return this.veiculos;
    }
    
    public List<Rota> getRotas(){
    return this.rotas;
}

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
    this.coletas = new ArrayList<>(); // Inicialize a lista de coletas
}
  
   public Departamento(
           String nome,
           String cep,
           String rua,
           String bairro,
           String cidade,
           String numero,
           String complemento,
           Administrador administrador,
           List<EstacaoDescarga> estacoesDescarga,
           List<Veiculo> veiculos,
           List<Supervisor> supervisores,
           List<Operador> operadores,
           List<Rota> rotas,
           List<Coleta> coletas
           ){
        this.nome = nome;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
        this.administrador = administrador;
        this.estacoesDescarga = estacoesDescarga;
        this.veiculos = veiculos;
        this.supervisores = supervisores;
        this.operadores = operadores;
        this.rotas = rotas;
        this.coletas = coletas;
   }

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getRua() {
       return rua;
   }

   public void setRua(String rua) {
       this.rua = rua;
   }

   public String getBairro() {
       return bairro;
   }

   public void setBairro(String bairro) {
       this.bairro = bairro;
   }

   public String getCidade() {
       return cidade;
   }

   public void setCidade(String cidade) {
       this.cidade = cidade;
   }

   public String getNumero() {
       return numero;
   }

   public void setNumero(String numero) {
       this.numero = numero;
   }

   public String getComplemento() {
       return complemento;
   }

   public void setComplemento(String complemento) {
       this.complemento = complemento;
   }

   public String getCep() {
       return cep;
   }

   public void setCep(String cep) {
       this.cep = cep;
   }

   public Administrador getAdministrador() {
       return administrador;
   }

   public void setAdministrador(Administrador administrador) {
       this.administrador = administrador;
   }

   public List<EstacaoDescarga> getEstacoesDescarga() {
       return estacoesDescarga;
   }

   public void setEstacoesDescarga(List<EstacaoDescarga> estacoesDescarga) {
       this.estacoesDescarga = estacoesDescarga;
   }
}
