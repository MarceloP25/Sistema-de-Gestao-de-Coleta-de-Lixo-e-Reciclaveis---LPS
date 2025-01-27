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

@Entity
@Getter
@Setter
public class Operador extends Pessoa {
    
    @ManyToOne
    private Departamento departamento;
    
    private String dataContrato;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "operador_id"),
        inverseJoinColumns = @JoinColumn(name = "veiculo_id")
    )
    private List<Veiculo> veiculos;

    @ManyToMany(mappedBy = "operador")
    private List<Rota> rotas;
    
    public Operador(){
        super();
        this.departamento = new Departamento();
        this.dataContrato = "00/00/0000";
        this.veiculos = new ArrayList<>();
        this.rotas = new ArrayList<>();
    }
    
    public Operador(          
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
            Departamento departamento,
            String dataContrato,
            List veiculos,
            List rotas){
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
        this.departamento = departamento;
        this.dataContrato = dataContrato;
        this.veiculos = veiculos;
        this.rotas = rotas;
        
    }

}

