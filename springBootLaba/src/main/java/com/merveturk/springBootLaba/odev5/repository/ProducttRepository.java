package com.merveturk.springBootLaba.odev5.repository;



import com.merveturk.springBootLaba.odev5.entity.Productt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class ProducttRepository {

    @PersistenceContext
    private EntityManager entityManager;

// hibarnate ile save işlemi
    @Transactional
    public Productt save( String name , String category ){
        Productt product = new Productt();
        product.setName(name);
        product.setCategory(category);
        Productt merge = entityManager.merge(product);
        return merge;

    }

}
