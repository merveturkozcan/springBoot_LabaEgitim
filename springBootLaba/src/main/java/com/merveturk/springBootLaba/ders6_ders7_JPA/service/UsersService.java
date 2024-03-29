package com.merveturk.springBootLaba.ders6_ders7_JPA.service;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.UsersSaveReguestDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.Users;
import com.merveturk.springBootLaba.ders6_ders7_JPA.mapper.UsersMapper;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }


    public void save(UsersSaveReguestDto usersSaveReguestDto) {
        Users users = usersMapper.userSaveRequestDtoToUser(usersSaveReguestDto);
        usersRepository.save(users);

    }

    public Optional<Users> findUserById (Long id ){
       return usersRepository.findById(id);
    }

}
