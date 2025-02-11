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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Cidadao;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.CidadaoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class CidadaoDAO implements IDAO<Cidadao> {

    private EntityManager entityManager;
    
    @Override
    public void save(Cidadao obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Cidadao obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Cidadao find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Cidadao cidadao = this.entityManager.find(Cidadao.class, id);

        this.entityManager.close();

        return cidadao;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Cidadao cidadaoJPA = this.entityManager.find(Cidadao.class, id);
        if (cidadaoJPA != null) {
            this.entityManager.remove(cidadaoJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new CidadaoException("Error - Cidadao inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Cidadao> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT c FROM Cidadao c";
        TypedQuery qry = this.entityManager.createQuery(jpql, Cidadao.class);

        List<Cidadao> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public Cidadao findByCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT c "
                + " FROM Cidadao c "
                + " WHERE c.cpf like :cpf";
        TypedQuery<Cidadao> qry = this.entityManager.createQuery(jpql, Cidadao.class);
        qry.setParameter("cpf", cpf);

        List lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Cidadao) lst.get(0);
        }
    }

    public List<Cidadao> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT c "
                + " FROM Cidadao c "
                + " WHERE c.nome like :nome ";
        TypedQuery<Cidadao> qry = this.entityManager.createQuery(jpql, Cidadao.class);
        qry.setParameter("nome", nome + "%");

        List<Cidadao> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
