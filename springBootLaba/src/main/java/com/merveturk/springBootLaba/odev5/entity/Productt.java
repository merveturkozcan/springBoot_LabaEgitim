package com.merveturk.springBootLaba.odev5.entity;


import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Data
@NoArgsConstructor

@Entity
@Table(name="product")
public class Productt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    private String category;

}
