package com.francesca.frattini.gymwebsite.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "allenatore")

public class Allenatore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allenatore_id", nullable = false)
    private Long allenatoreId;
    private String nome;
    private String cognome;
    private Long telefono;
    private String email;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Allenamenti allenamenti;

    public void setRoles(Set<Role> rolesSet) {
    }
}
