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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Coleta;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.ColetaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class ColetaDAO implements IDAO<Coleta> {

    private EntityManager entityManager;
    
    @Override
    public void save(Coleta obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Coleta obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Coleta find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        Coleta coleta = this.entityManager.find(Coleta.class, id);

        this.entityManager.close();

        return coleta;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Coleta coletaJPA = this.entityManager.find(Coleta.class, id);
        if (coletaJPA != null) {
            this.entityManager.remove(coletaJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new ColetaException("Error - Coleta inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Coleta> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Coleta a";
        TypedQuery qry = this.entityManager.createQuery(jpql, Coleta.class);

        List<Coleta> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public List<Coleta> filterByEstacao(String estacaoDeDescarga) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Coleta a "
                + " WHERE a.estacaoDeDescarga like :estacaoDeDescarga ";
        TypedQuery<Coleta> qry = this.entityManager.createQuery(jpql, Coleta.class);
        qry.setParameter("estacao", estacaoDeDescarga + "%");

        List<Coleta> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<Coleta> filterByDepartamento(String departamento) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Coleta a "
                + " WHERE a.departamento like :departamento ";
        TypedQuery<Coleta> qry = this.entityManager.createQuery(jpql, Coleta.class);
        qry.setParameter("departamento", departamento + "%");

        List<Coleta> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}

