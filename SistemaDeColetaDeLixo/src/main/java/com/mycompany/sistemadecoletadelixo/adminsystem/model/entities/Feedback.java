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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        joinColumns = @JoinColumn(name = "feedback_id"),
        inverseJoinColumns = @JoinColumn(name = "admin_id")
    )
    private List<Administrador> adminFeed;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        joinColumns = @JoinColumn(name = "feedback_id"),
        inverseJoinColumns = @JoinColumn(name = "cidaddao_id")
    )
    private List<Cidadao> cidadaoFeed;
}
