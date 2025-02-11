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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.EstacaoDescarga;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.EstacaoDescargaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class EstacaoDescargaDAO implements IDAO<EstacaoDescarga> {

    private EntityManager entityManager;
    
    @Override
    public void save(EstacaoDescarga obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(EstacaoDescarga obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public EstacaoDescarga find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        EstacaoDescarga estacaoDescarga = this.entityManager.find(EstacaoDescarga.class, id);

        this.entityManager.close();

        return estacaoDescarga;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        EstacaoDescarga estacaoDescargaJPA = this.entityManager.find(EstacaoDescarga.class, id);
        if (estacaoDescargaJPA != null) {
            this.entityManager.remove(estacaoDescargaJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new EstacaoDescargaException("Error - Estacao de Descarga inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<EstacaoDescarga> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM EstacaoDescarga a";
        TypedQuery qry = this.entityManager.createQuery(jpql, EstacaoDescarga.class);

        List<EstacaoDescarga> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<EstacaoDescarga> filterByDepartamento(String departamento) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM EstacaoDescarga a "
                + " WHERE a.departamento like :departamento ";
        TypedQuery<EstacaoDescarga> qry = this.entityManager.createQuery(jpql, EstacaoDescarga.class);
        qry.setParameter("departamento", departamento + "%");

        List<EstacaoDescarga> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<EstacaoDescarga> filterByName(String nomeEstacao) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM EstacaoDescarga a "
                + " WHERE a.nomeEstacao like :nomeEstacao ";
        TypedQuery<EstacaoDescarga> qry = this.entityManager.createQuery(jpql, EstacaoDescarga.class);
        qry.setParameter("nomeEstacao", nomeEstacao + "%");

        List<EstacaoDescarga> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
