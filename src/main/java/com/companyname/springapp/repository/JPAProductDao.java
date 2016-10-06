package com.companyname.springapp.repository;

/**
 * Created by pepesan on 6/10/16.
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.companyname.springapp.domain.Product;

@Repository(value = "productDao")
public class JPAProductDao implements ProductDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
        return em.createQuery("select p from Product p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveProduct(Product prod) {
        em.merge(prod);
    }

    @Transactional(readOnly = false)
    public void addProduct(Product product) {
        em.persist(product);
    }

}