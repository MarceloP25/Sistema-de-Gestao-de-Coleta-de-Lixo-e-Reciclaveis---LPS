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

@Entity
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getConsumoPorKm() {
        return consumoPorKm;
    }

    public void setConsumoPorKm(float consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public char getCarteiraConducao() {
        return carteiraConducao;
    }

    public void setCarteiraConducao(char carteiraConducao) {
        this.carteiraConducao = carteiraConducao;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(String dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Operador> getOperador() {
        return operador;
    }

    public void setOperador(List<Operador> operador) {
        this.operador = operador;
    }
}
