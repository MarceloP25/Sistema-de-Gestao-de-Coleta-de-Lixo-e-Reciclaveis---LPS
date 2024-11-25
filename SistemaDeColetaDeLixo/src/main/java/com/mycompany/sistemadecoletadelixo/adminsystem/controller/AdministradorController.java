package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entity.Administrador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AdministradorController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarAdministrador(Administrador administrador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(administrador);
        em.getTransaction().commit();
        em.close();
    }

    public Administrador buscarAdministrador(Long id) {
        EntityManager em = emf.createEntityManager();
        Administrador administrador = em.find(Administrador.class, id);
        em.close();
        return administrador;
    }

    public void atualizarAdministrador(Administrador administrador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(administrador);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarAdministrador(Long id) {
        EntityManager em = emf.createEntityManager();
        Administrador administrador = em.find(Administrador.class, id);
        if (administrador != null) {
            em.getTransaction().begin();
            em.remove(administrador);
            em.getTransaction().commit();
        }
        em.close();
    }
}