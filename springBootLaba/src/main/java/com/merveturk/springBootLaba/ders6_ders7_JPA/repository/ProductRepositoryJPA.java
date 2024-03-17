package com.merveturk.springBootLaba.ders6_ders7_JPA.repository;

import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepositoryJPA extends CrudRepository < ProductJpa, Long >  {


}
