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
@Inheritance(strategy = InheritanceType.JOINED)
public class PontoDeColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;

    @Column(name = "numero_lixeiras")
    private Integer numeroLixeiras;

    @Column(name = "tipos_lixo")
    private String tiposLixo;

}

