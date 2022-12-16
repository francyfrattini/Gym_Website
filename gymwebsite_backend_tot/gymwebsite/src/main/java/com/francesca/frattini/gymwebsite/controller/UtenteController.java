package com.francesca.frattini.gymwebsite.controller;

import com.francesca.frattini.gymwebsite.entities.Utente;
import com.francesca.frattini.gymwebsite.repositories.UtenteRepository;
import com.francesca.frattini.gymwebsite.services.UtenteService;
import com.francesca.frattini.gymwebsite.utils.ConverterData;
import com.francesca.frattini.gymwebsite.utilsRequestModels.UtenteRequest;
import com.francesca.frattini.gymwebsite.utilsResponseModels.UtenteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/utenti")
@Slf4j
@CrossOrigin(origins = "*")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteRepository utenteRepository;

    //GET ALL
    @GetMapping("")
    @PreAuthorize("hasRole('ALLENATORE')")
    @CrossOrigin
    public ResponseEntity<List<Utente>> getAllUtenti() {

        return new ResponseEntity<>( utenteService.getAll(), HttpStatus.OK );

    }

    @GetMapping("/pageable")
    @PreAuthorize("hasRole('ALLENATORE')")
    @CrossOrigin
    public ResponseEntity<Page<Utente>> getAllUtentiPageable(Pageable p) {

        return new ResponseEntity<>( utenteService.getAllPaginate(p), HttpStatus.OK );

    }

    // GET
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<Utente> getById( @PathVariable Long id ) throws Exception {

        return new ResponseEntity<>(
                utenteService.getById( id ),
                HttpStatus.OK
        );
    }

    // CREATE
    @PostMapping("/new-raw")
    @PreAuthorize("hasAnyRole('ALLENATORE', 'UTENTE')")
    public ResponseEntity<UtenteResponse> create(@RequestBody UtenteRequest utenteRequest ) {

        try {

            return new ResponseEntity<>( utenteService.createAndSave( utenteRequest ), HttpStatus.OK );

        } catch( Exception e ) {

            log.error( e.getMessage() );

        }

        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );

    }

    //UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ALLENATORE', 'UTENTE')")
    public ResponseEntity<UtenteResponse> update( @RequestBody UtenteRequest utenteRequest, @PathVariable("id") Long id  ) {

        try {

            return new ResponseEntity<>( utenteService.updateResponse( utenteRequest, id ), HttpStatus.OK );

        } catch( Exception e ) {

            log.error( e.getMessage() );

        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    public void deleteById( @PathVariable Long id ) {

        try {

            utenteService.delete( id );

        } catch( Exception e ) {

            log.error( e.getMessage() );

        }

    }

    ///////////////////////// QUERY PERSONALIZZATE/////////////////////////
    ///////////////////////////////////////////////////////////////////////


    // RITORNA UNA LISTA DI CLIENTI ORDINATI PER USER ID
    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<List<Utente>> getUtenteByUserId( @PathVariable("id") Long id ) {
        return new ResponseEntity<>(
                utenteRepository.findUtenteByUserId( id ),
                HttpStatus.OK
        );
    }

    // RITORNA UNA PAGINAZIONE DI TUTTI I CLIENTI ORDINATI PER NOME
    @GetMapping("/nome/")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<Page<Utente>> getByNome( Pageable p ) {
        return new ResponseEntity<>(
                utenteService.getByNome( p ),
                HttpStatus.OK
        );
    }

    //    //RITORNA UNA LISTA DI CLIENTI FILTRATI PER DATA ISCRIZIONE
    @GetMapping("/filter-data-iscrizione/{data}")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<Page<Utente>> getByDataIscrizione( @PathVariable("data") String stringData, Pageable p ) {

        return new ResponseEntity<>(
                utenteService.filterByDataIscrizione( ConverterData.convertData( stringData ), p ),
                HttpStatus.OK
        );
    }

    // RITORNA UNA LISTA DI CLIENTI FILTRATI PER NOME E COGNOME
    @GetMapping("/filter-nome-cognome/{nome}/{cognome}")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<Page<Utente>> filterByNomeECognome( @PathVariable("nome") String nome,
                                                               @PathVariable("cognome") String cognome,
                                                               Pageable p ) {
        return new ResponseEntity<>(
                utenteService.filterByNomeECognome( nome, cognome, p ),
                HttpStatus.OK
        );
    }

}
