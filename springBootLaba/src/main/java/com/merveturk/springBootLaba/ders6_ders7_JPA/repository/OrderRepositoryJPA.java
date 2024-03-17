package com.merveturk.springBootLaba.ders6_ders7_JPA.repository;

import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderJpa;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepositoryJPA extends CrudRepository <OrderJpa,Long >  {

}
