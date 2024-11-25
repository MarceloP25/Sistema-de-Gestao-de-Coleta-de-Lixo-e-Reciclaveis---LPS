package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FrCadDepartamentoController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarDepartamento(Departamento departamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(departamento);
        em.getTransaction().commit();
        em.close();
    }

    public Departamento buscarDepartamento(Long id) {
        EntityManager em = emf.createEntityManager();
        Departamento departamento = em.find(Departamento.class, id);
        em.close();
        return departamento;
    }

    public void atualizarDepartamento(Departamento departamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(departamento);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarDepartamento(Long id) {
        EntityManager em = emf.createEntityManager();
        Departamento departamento = em.find(Departamento.class, id);
        if (departamento != null) {
            em.getTransaction().begin();
            em.remove(departamento);
            em.getTransaction().commit();
        }
        em.close();
    }
}