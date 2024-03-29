package com.merveturk.springBootLaba.ders6_ders7_JPA.repository;


import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.Users;
import org.springframework.data.repository.CrudRepository;



public interface UsersRepository extends CrudRepository <Users,Long >  {
}
