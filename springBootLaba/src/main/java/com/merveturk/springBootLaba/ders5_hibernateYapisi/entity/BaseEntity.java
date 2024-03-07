package com.merveturk.springBootLaba.ders5_hibernateYapisi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @CreationTimestamp
    private Date createDate;

    @Column
    @UpdateTimestamp
    private Date updateDate;

}
