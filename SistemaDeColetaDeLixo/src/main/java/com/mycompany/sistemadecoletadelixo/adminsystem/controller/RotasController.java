package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Rota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RotasController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarRota(Rota rota) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(rota);
        em.getTransaction().commit();
        em.close();
    }

    public Rota buscarRota(Long id) {
        EntityManager em = emf.createEntityManager();
        Rota rota = em.find(Rota.class, id);
        em.close();
        return rota;
    }

    public void atualizarRota(Rota rota) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(rota);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarRota(Long id) {
        EntityManager em = emf.createEntityManager();
        Rota rota = em.find(Rota.class, id);
        if (rota != null) {
            em.getTransaction().begin();
            em.remove(rota);
            em.getTransaction().commit();
        }
        em.close();
    }
}