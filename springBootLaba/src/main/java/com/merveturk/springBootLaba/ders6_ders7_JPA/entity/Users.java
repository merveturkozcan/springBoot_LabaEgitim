package com.merveturk.springBootLaba.ders6_ders7_JPA.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor

@Entity
@Table(name = "usersJpa")
public class Users extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

}
