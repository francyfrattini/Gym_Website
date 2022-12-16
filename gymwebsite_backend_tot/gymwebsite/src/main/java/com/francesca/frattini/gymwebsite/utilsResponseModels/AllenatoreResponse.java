package com.francesca.frattini.gymwebsite.utilsResponseModels;

import com.francesca.frattini.gymwebsite.entities.Allenamenti;
import com.francesca.frattini.gymwebsite.entities.Allenatore;
import com.francesca.frattini.gymwebsite.entities.Utente;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AllenatoreResponse {
    private Long allenatoreId;
    private String nome;
    private String cognome;
    private Long telefono;
    private String email;
    private String username;
    private String password;
    private Allenamenti allenamenti;

    public static AllenatoreResponse parseAllenatore( Allenatore allenatore ) {
        return AllenatoreResponse.builder()
                .allenatoreId( allenatore.getAllenatoreId())
                .username( allenatore.getUsername() )
                .email( allenatore.getEmail() )
                .nome( allenatore.getNome() )
                .cognome( allenatore.getCognome() )
                .telefono( allenatore.getTelefono() )
                .allenamenti(allenatore.getAllenamenti())
                .build();

    }
}
