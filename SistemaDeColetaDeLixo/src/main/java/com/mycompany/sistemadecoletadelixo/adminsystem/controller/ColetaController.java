package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Coleta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ColetaController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarColeta(Coleta coleta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(coleta);
        em.getTransaction().commit();
        em.close();
    }

    public Coleta buscarColeta(Long id) {
        EntityManager em = emf.createEntityManager();
        Coleta coleta = em.find(Coleta.class, id);
        em.close();
        return coleta;
    }

    public void atualizarColeta(Coleta coleta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(coleta);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarColeta(Long id) {
        EntityManager em = emf.createEntityManager();
        Coleta coleta = em.find(Coleta.class, id);
        if (coleta != null) {
            em.getTransaction().begin();
            em.remove(coleta);
            em.getTransaction().commit();
        }
        em.close();
    }
}