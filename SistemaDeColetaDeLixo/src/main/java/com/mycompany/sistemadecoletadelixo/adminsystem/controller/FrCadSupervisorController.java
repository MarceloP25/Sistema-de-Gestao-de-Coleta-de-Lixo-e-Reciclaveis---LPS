package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.Supervisor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FrCadSupervisorController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarSupervisor(Supervisor supervisor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(supervisor);
        em.getTransaction().commit();
        em.close();
    }

    public Supervisor buscarSupervisor(Long id) {
        EntityManager em = emf.createEntityManager();
        Supervisor supervisor = em.find(Supervisor.class, id);
        em.close();
        return supervisor;
    }

    public void atualizarSupervisor(Supervisor supervisor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(supervisor);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarSupervisor(Long id) {
        EntityManager em = emf.createEntityManager();
        Supervisor supervisor = em.find(Supervisor.class, id);
        if (supervisor != null) {
            em.getTransaction().begin();
            em.remove(supervisor);
            em.getTransaction().commit();
        }
        em.close();
    }
}