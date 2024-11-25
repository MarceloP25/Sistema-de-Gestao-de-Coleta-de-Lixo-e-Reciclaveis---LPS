package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.EstacaoDescarga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EstacaoDescargaController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarEstacaoDescarga(EstacaoDescarga estacaoDescarga) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(estacaoDescarga);
        em.getTransaction().commit();
        em.close();
    }

    public EstacaoDescarga buscarEstacaoDescarga(Long id) {
        EntityManager em = emf.createEntityManager();
        EstacaoDescarga estacaoDescarga = em.find(EstacaoDescarga.class, id);
        em.close();
        return estacaoDescarga;
    }

    public void atualizarEstacaoDescarga(EstacaoDescarga estacaoDescarga) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(estacaoDescarga);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarEstacaoDescarga(Long id) {
        EntityManager em = emf.createEntityManager();
        EstacaoDescarga estacaoDescarga = em.find(EstacaoDescarga.class, id);
        if (estacaoDescarga != null) {
            em.getTransaction().begin();
            em.remove(estacaoDescarga);
            em.getTransaction().commit();
        }
        em.close();
    }
}