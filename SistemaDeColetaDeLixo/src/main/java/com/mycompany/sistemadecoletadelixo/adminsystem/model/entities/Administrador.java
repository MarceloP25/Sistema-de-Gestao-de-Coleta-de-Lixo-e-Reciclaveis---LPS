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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Administrador extends Pessoa {
    
    @OneToMany(mappedBy = "administrador")
    private List<Departamento> departamentos;
    
    @ManyToMany(mappedBy = "adminFeed")
    private List<Feedback> feedbacks;
    
    public Administrador() {
        super();
        this.departamentos = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }
    
    public Administrador(          
            String nome, 
            char sexo, 
            String dataNascimento, 
            String cpf, 
            String email,
            String senha,
            String telefone, 
            String cep,
            String rua,
            String bairro,
            String cidade,
            String numero,
            String complemento,
            List<Departamento> departamentos,
            List<Feedback> feedbacks) {
        super(
            nome, 
            sexo, 
            dataNascimento, 
            cpf, 
            email,
            senha,
            telefone, 
            cep,
            rua,
            bairro,
            cidade,
            numero,
            complemento);
        this.departamentos = departamentos;
    }
    
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
    
    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public void setId(Long id) {
        this.id = id;    
    }
}
