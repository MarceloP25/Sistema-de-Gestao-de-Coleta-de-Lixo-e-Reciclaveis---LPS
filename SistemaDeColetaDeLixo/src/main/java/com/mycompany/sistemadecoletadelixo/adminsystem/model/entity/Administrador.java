/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entity;

/**
 *
 * @author marce
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Administrador extends Pessoa {
    
    private int idDepartamento;

    @OneToMany(mappedBy = "administrador")
    private List<Departamento> departamentos;
    
    public Administrador(){
        super();
        this.idDepartamento = -1;
    }
}


