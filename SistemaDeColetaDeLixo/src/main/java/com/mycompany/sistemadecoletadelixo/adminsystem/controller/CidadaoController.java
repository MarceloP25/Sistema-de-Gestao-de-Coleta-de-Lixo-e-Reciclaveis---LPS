package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.Cidadao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CidadaoController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarAdminHome(Cidadao cidadao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cidadao);
        em.getTransaction().commit();
        em.close();
    }

    public Cidadao buscarAdminHome(Long id) {
        EntityManager em = emf.createEntityManager();
        Cidadao cidadao = em.find(Cidadao.class, id);
        em.close();
        return cidadao;
    }

    public void atualizarAdminHome(Cidadao cidadao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cidadao);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarAdminHome(Long id) {
        EntityManager em = emf.createEntityManager();
        CIdadao cidadao = em.find(CIdadao.class, id);
        if (cidadao != null) {
            em.getTransaction().begin();
            em.remove(cidadao);
            em.getTransaction().commit();
        }
        em.close();
    }
}