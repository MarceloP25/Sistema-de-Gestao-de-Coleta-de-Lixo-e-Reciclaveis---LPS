package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.AdminHome;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FrHomeAdminController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarAdminHome(AdminHome adminHome) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(adminHome);
        em.getTransaction().commit();
        em.close();
    }

    public AdminHome buscarAdminHome(Long id) {
        EntityManager em = emf.createEntityManager();
        AdminHome adminHome = em.find(AdminHome.class, id);
        em.close();
        return adminHome;
    }

    public void atualizarAdminHome(AdminHome adminHome) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(adminHome);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarAdminHome(Long id) {
        EntityManager em = emf.createEntityManager();
        AdminHome adminHome = em.find(AdminHome.class, id);
        if (adminHome != null) {
            em.getTransaction().begin();
            em.remove(adminHome);
            em.getTransaction().commit();
        }
        em.close();
    }
}