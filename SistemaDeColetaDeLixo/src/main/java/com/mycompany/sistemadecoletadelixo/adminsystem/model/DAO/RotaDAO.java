/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO;

/**
 *
 * @author marce
 */
import com.mycompany.sistemadecoletadelixo.adminsystem.factory.DatabaseJPA;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Rota;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.RotaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class RotaDAO implements IDAO<Rota> {

    private EntityManager entityManager;
    
    @Override
    public void save(Rota obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Rota obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Rota find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        Rota rota = this.entityManager.find(Rota.class, id);

        this.entityManager.close();

        return rota;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Rota rotaJPA = this.entityManager.find(Rota.class, id);
        if (rotaJPA != null) {
            this.entityManager.remove(rotaJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RotaException("Error - Rota inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Rota> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Rota a";
        TypedQuery qry = this.entityManager.createQuery(jpql, Rota.class);

        List<Rota> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<Rota> filterByName(String nomeRota) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Rota a "
                + " WHERE a.nomeRota like :nomeRota ";
        TypedQuery<Rota> qry = this.entityManager.createQuery(jpql, Rota.class);
        qry.setParameter("nomeRota", nomeRota + "%");

        List<Rota> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
}
