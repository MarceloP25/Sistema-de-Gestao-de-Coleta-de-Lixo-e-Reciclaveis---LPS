package com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO;

/**
 *
 * @author marce
 */

import java.util.*;

public interface IDAO<T> {
    void save(T obj);
    void update(T obj);
    boolean delete(Long id);           
    T find(Long id);        
    List<T> findAll();
}

