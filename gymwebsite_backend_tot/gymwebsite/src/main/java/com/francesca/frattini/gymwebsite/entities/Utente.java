package com.francesca.frattini.gymwebsite.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "utenti")

public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utente_id", nullable = false)
    private Long utenteId;
    private String nome;
    private String cognome;
    private Long telefono;
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private LocalDate dataIscrizione;

    @OneToOne // UN UTENTE PUO' AVERE UN RUOLO
    @JoinTable(name = "users_roles", //Nome della tabbella che verrà creata
            joinColumns = @JoinColumn(name = "user_id"),// Crea colonna
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles = new HashSet<Role>();
    private Boolean active = true;
    public void addRole( Role r ) {

        this.roles.add( r );

    }
}
