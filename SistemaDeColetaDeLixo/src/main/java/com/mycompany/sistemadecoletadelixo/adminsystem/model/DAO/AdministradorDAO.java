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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Administrador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.AdministradorException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class AdministradorDAO implements IDAO<Administrador> {

    private EntityManager entityManager;
    
    @Override
    public void save(Administrador obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Administrador obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Administrador find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        Administrador administrador = this.entityManager.find(Administrador.class, id);

        this.entityManager.close();

        return administrador;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Administrador adminJPA = this.entityManager.find(Administrador.class, id);
        if (adminJPA != null) {
            this.entityManager.remove(adminJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new AdministradorException("Error - Administrador inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Administrador> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Administrador a";
        TypedQuery qry = this.entityManager.createQuery(jpql, Administrador.class);

        List<Administrador> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public Administrador findByCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Administrador a "
                + " WHERE a.cpf like :cpf";
        TypedQuery<Administrador> qry = this.entityManager.createQuery(jpql, Administrador.class);
        qry.setParameter("cpf", cpf);

        List lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Administrador) lst.get(0);
        }
    }

    public List<Administrador> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Administrador a "
                + " WHERE a.nome like :nome ";
        TypedQuery<Administrador> qry = this.entityManager.createQuery(jpql, Administrador.class);
        qry.setParameter("nome", nome + "%");

        List<Administrador> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}


