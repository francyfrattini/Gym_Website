package com.francesca.frattini.gymwebsite.utilsRequestModels;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UtenteRequest {

    private Long utenteId;
    private String nome;
    private String cognome;
    private Long telefono;
    private String email;
    private String username;
    private String password;
    private LocalDate dataIscrizione ;


}
