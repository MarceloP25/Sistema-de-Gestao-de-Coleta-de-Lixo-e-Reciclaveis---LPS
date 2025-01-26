/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
@Entity
@Getter
@Setter
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String chassi;
    private String modelo;
    private Float kilometragem;
    private Integer eixos;
    private Float comprimento;
    private Float altura;
    private Float largura;

    @Column(name = "carteira_conducao")
    private Character carteiraConducao;

    private Float carga;

    private String combustivel;

    @Column(name = "data_manutencao")
    private LocalDate dataManutencao;

    @Column(name = "emissao_poluentes")
    private Float emissaoPoluentes;


}
