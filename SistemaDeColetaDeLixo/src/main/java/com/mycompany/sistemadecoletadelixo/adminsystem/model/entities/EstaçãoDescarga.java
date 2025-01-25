/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
import jakarta.persistence.*;

@Entity
@Table(name = "estacao_descarga")
public class EstacaoDescarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacao")
    private Long idEstacao;

    @Column(name = "nome_estacao", nullable = false, length = 100)
    private String nomeEstacao;

    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "capacidade_maxima", nullable = false)
    private Double capacidadeMaxima;

    @Column(name = "tipo_material_aceito", length = 100)
    private String tipoMaterialAceito;

    @Column(name = "status_operacao", nullable = false, length = 50)
    private String statusOperacao;

    // Getters e Setters

    public Long getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Long idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getTipoMaterialAceito() {
        return tipoMaterialAceito;
    }

    public void setTipoMaterialAceito(String tipoMaterialAceito) {
        this.tipoMaterialAceito = tipoMaterialAceito;
    }

    public String getStatusOperacao() {
        return statusOperacao;
    }

    public void setStatusOperacao(String statusOperacao) {
        this.statusOperacao = statusOperacao;
    }
}

