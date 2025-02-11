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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.PontoDeColeta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.PontoDeColetaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class PontoDeColetaDAO implements IDAO<PontoDeColeta> {

    private EntityManager entityManager;
    
    @Override
    public void save(PontoDeColeta obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(PontoDeColeta obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public PontoDeColeta find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        PontoDeColeta pontoDeColeta = this.entityManager.find(PontoDeColeta.class, id);

        this.entityManager.close();

        return pontoDeColeta;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        PontoDeColeta ptColetaJPA = this.entityManager.find(PontoDeColeta.class, id);
        if (ptColetaJPA != null) {
            this.entityManager.remove(ptColetaJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new PontoDeColetaException("Error - PontoDeColeta inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<PontoDeColeta> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM PontoDeColeta a";
        TypedQuery qry = this.entityManager.createQuery(jpql, PontoDeColeta.class);

        List<PontoDeColeta> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<PontoDeColeta> filterByName(String nomePonto) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM PontoDeColeta a "
                + " WHERE a.nomePonto like :nomePonto ";
        TypedQuery<PontoDeColeta> qry = this.entityManager.createQuery(jpql, PontoDeColeta.class);
        qry.setParameter("nomePonto", nomePonto + "%");

        List<PontoDeColeta> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
}
