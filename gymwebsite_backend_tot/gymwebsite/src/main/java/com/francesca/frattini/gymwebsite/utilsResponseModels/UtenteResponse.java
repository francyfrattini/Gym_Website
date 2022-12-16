package com.francesca.frattini.gymwebsite.utilsResponseModels;

import com.francesca.frattini.gymwebsite.entities.Utente;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UtenteResponse {


    private Long utenteId;
    private String nome;
    private String cognome;
    private Long telefono;
    private String email;
    private String username;
    private String password;
    private LocalDate dataIscrizione ;
    ;

    public static UtenteResponse parseUtente( Utente utente ) {
        return UtenteResponse.builder()
                .utenteId( utente.getUtenteId() )
                .username( utente.getUsername() )
                .email( utente.getEmail() )
                .nome( utente.getNome() )
                .cognome( utente.getCognome() )
                .telefono( utente.getTelefono() )
                .dataIscrizione( utente.getDataIscrizione() )
                .build();

    }

}
