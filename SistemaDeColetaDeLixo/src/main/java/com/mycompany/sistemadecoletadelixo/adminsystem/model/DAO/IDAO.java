/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO;

/**
 *
 * @author marce
 */
public interface IDAO<T> {
    void save(T obj);
    void update(T obj);
    boolean delete(Long id);           
    T find(Long id);        
    List<T> findAll();
}

