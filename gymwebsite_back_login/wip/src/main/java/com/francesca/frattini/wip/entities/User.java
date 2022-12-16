package com.francesca.frattini.wip.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private Long userId;
    private String name;
    private String surname;
    private String gender;
    private int phone;
    private String email;
    private String password;
    private String cpassword;

}
