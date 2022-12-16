package com.francesca.frattini.gymwebsite.utilsRequestModels;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AllenatoreRequest {
    private Long allenatoreId;
    private String nome;
    private String cognome;
    private Long telefono;
    private String email;
    private String username;
    private String password;
    private String allenamenti;

}
