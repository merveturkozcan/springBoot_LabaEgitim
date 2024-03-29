package com.merveturk.springBootLaba.ders6_ders7_JPA.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersSaveReguestDto {

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

}
