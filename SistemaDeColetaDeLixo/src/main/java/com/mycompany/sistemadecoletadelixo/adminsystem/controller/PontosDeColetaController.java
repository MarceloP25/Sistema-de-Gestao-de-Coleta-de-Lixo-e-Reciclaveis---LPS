package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.PontoDeColeta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PontosDeColetaController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarPontoDeColeta(PontoDeColeta pontoDeColeta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pontoDeColeta);
        em.getTransaction().commit();
        em.close();
    }

    public PontoDeColeta buscarPontoDeColeta(Long id) {
        EntityManager em = emf.createEntityManager();
        PontoDeColeta pontoDeColeta = em.find(PontoDeColeta.class, id);
        em.close();
        return pontoDeColeta;
    }

    public void atualizarPontoDeColeta(PontoDeColeta pontoDeColeta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pontoDeColeta);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarPontoDeColeta(Long id) {
        EntityManager em = emf.createEntityManager();
        PontoDeColeta pontoDeColeta = em.find(PontoDeColeta.class, id);
        if (pontoDeColeta != null) {
            em.getTransaction().begin();
            em.remove(pontoDeColeta);
            em.getTransaction().commit();
        }
        em.close();
    }
}