package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.Material;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MaterialController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarMaterial(Material material) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(material);
        em.getTransaction().commit();
        em.close();
    }

    public Material buscarMaterial(Long id) {
        EntityManager em = emf.createEntityManager();
        Material material = em.find(Material.class, id);
        em.close();
        return material;
    }

    public void atualizarMaterial(Material material) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(material);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarMaterial(Long id) {
        EntityManager em = emf.createEntityManager();
        Material material = em.find(Material.class, id);
        if (material != null) {
            em.getTransaction().begin();
            em.remove(material);
            em.getTransaction().commit();
        }
        em.close();
    }
}