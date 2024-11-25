package com.mycompany.sistemadecoletadelixo.adminsystem.controller;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.classes.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FrCadVeiculosController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminPU");

    public void salvarVeiculo(Veiculo veiculo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        em.close();
    }

    public Veiculo buscarVeiculo(Long id) {
        EntityManager em = emf.createEntityManager();
        Veiculo veiculo = em.find(Veiculo.class, id);
        em.close();
        return veiculo;
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarVeiculo(Long id) {
        EntityManager em = emf.createEntityManager();
        Veiculo veiculo = em.find(Veiculo.class, id);
        if (veiculo != null) {
            em.getTransaction().begin();
            em.remove(veiculo);
            em.getTransaction().commit();
        }
        em.close();
    }
}