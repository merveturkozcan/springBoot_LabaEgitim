package com.merveturk.springBootLaba.odev5.repository;



import com.merveturk.springBootLaba.odev5.entity.Productt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class ProducttRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void save( String name , String category ){
        Productt product = new Productt();
        product.setName(name);
        product.setCategory(category);
        entityManager.merge(product);

    }
}
