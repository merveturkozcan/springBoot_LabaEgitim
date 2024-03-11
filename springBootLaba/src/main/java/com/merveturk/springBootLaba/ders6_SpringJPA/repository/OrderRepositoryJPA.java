package com.merveturk.springBootLaba.ders6_SpringJPA.repository;

import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.ProductJpa;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepositoryJPA extends CrudRepository <OrderJpa,Long >  {

}
