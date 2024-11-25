package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.Operador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FrCadOperadorController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarOperador(Operador operador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(operador);
        em.getTransaction().commit();
        em.close();
    }

    public Operador buscarOperador(Long id) {
        EntityManager em = emf.createEntityManager();
        Operador operador = em.find(Operador.class, id);
        em.close();
        return operador;
    }

    public void atualizarOperador(Operador operador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(operador);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarOperador(Long id) {
        EntityManager em = emf.createEntityManager();
        Operador operador = em.find(Operador.class, id);
        if (operador != null) {
            em.getTransaction().begin();
            em.remove(operador);
            em.getTransaction().commit();
        }
        em.close();
    }
}