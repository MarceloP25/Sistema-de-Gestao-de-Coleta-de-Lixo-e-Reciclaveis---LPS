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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Material;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.MaterialException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class MaterialDAO implements IDAO<Material> {

    private EntityManager entityManager;
    
    @Override
    public void save(Material obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Material obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Material find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        Material material = this.entityManager.find(Material.class, id);

        this.entityManager.close();

        return material;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Material materialJPA = this.entityManager.find(Material.class, id);
        if (materialJPA != null) {
            this.entityManager.remove(materialJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new MaterialException("Error - Material inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Material> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Material a";
        TypedQuery qry = this.entityManager.createQuery(jpql, Material.class);

        List<Material> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<Material> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Material a "
                + " WHERE a.nome like :nome ";
        TypedQuery<Material> qry = this.entityManager.createQuery(jpql, Material.class);
        qry.setParameter("nome", nome + "%");

        List<Material> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<Material> filterByType(String tipo) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Material a "
                + " WHERE a.tipo like :tipo ";
        TypedQuery<Material> qry = this.entityManager.createQuery(jpql, Material.class);
        qry.setParameter("nome", tipo + "%");

        List<Material> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}

