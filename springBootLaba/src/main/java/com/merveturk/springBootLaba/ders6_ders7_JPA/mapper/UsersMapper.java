package com.merveturk.springBootLaba.ders6_ders7_JPA.mapper;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductResponseByCategoryDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.UsersSaveReguestDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {




    Users userSaveRequestDtoToUser(UsersSaveReguestDto usersSaveRequestDto);



}
