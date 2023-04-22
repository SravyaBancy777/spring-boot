package com.springboot.demo.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length=100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Email
    @Column(nullable = false, length = 200)
    private String email;

    @Column(nullable = false, length = 100)
    private int age;


}
