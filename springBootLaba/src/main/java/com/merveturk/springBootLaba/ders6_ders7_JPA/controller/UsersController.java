package com.merveturk.springBootLaba.ders6_ders7_JPA.controller;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.UsersSaveReguestDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @PostMapping("/save")
    public void save(@RequestBody UsersSaveReguestDto usersSaveReguestDto){
       usersService.save(usersSaveReguestDto);

    }

}
