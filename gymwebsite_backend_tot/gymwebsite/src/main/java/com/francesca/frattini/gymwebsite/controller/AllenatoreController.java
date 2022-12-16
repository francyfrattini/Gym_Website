package com.francesca.frattini.gymwebsite.controller;

import com.francesca.frattini.gymwebsite.entities.Allenatore;
import com.francesca.frattini.gymwebsite.entities.Utente;
import com.francesca.frattini.gymwebsite.repositories.AllenatoreRepository;
import com.francesca.frattini.gymwebsite.services.AllenatoreService;
import com.francesca.frattini.gymwebsite.utilsRequestModels.AllenatoreRequest;
import com.francesca.frattini.gymwebsite.utilsResponseModels.AllenatoreResponse;
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
@RequestMapping("/api/allenatori")
@Slf4j
@CrossOrigin(origins = "*")
public class AllenatoreController {
    @Autowired
    private AllenatoreService allenatoreService;

    @Autowired
    private AllenatoreRepository allenatoreRepository;

    //GET ALL
    @GetMapping("")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    @CrossOrigin
    public ResponseEntity<List<Allenatore>> getAllAllenatori() {

        return new ResponseEntity<>( allenatoreService.getAll(), HttpStatus.OK );

    }

    @GetMapping("/pageable")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    @CrossOrigin
    public ResponseEntity<Page<Allenatore>> getAllAllenatoriPageable(Pageable p) {

        return new ResponseEntity<>( allenatoreService.getAllPaginate(p), HttpStatus.OK );

    }

    // GET
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    public ResponseEntity<Allenatore> getById(@PathVariable Long id ) throws Exception {

        return new ResponseEntity<Allenatore>(
                allenatoreService.getById( id ),
                HttpStatus.OK);
        
    }

    // CREATE
    @PostMapping("/new-raw")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<AllenatoreResponse> create(@RequestBody AllenatoreRequest allenatoreRequest ) {

        try {

            return new ResponseEntity<>( allenatoreService.createAndSave( allenatoreRequest ), HttpStatus.OK );

        } catch( Exception e ) {

            log.error( e.getMessage() );

        }

        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );

    }

    //UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ALLENATORE')")
    public ResponseEntity<AllenatoreResponse> update( @RequestBody AllenatoreRequest allenatoreRequest, @PathVariable("id") Long id  ) {

        try {

            return new ResponseEntity<>( allenatoreService.updateResponse( allenatoreRequest, id ), HttpStatus.OK );

        } catch( Exception e ) {

            log.error( e.getMessage() );

        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ALLENATORE')")
    public void deleteById( @PathVariable Long id ) {

        try {

            allenatoreService.delete( id );

        } catch( Exception e ) {

            log.error( e.getMessage() );

        }

    }

    ///////////////////////// QUERY PERSONALIZZATE/////////////////////////
    ///////////////////////////////////////////////////////////////////////


    // RITORNA UNA LISTA DI ALLENATORI ORDINATI PER USER ID
    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    public ResponseEntity<List<Allenatore>> getAllenatoreByUserId( @PathVariable("id") Long id ) {
        return new ResponseEntity<>(
                allenatoreRepository.findAllenatoreByUserId( id ),
                HttpStatus.OK
        );
    }

    // RITORNA UNA PAGINAZIONE DI TUTTI GLI ALLENATORI ORDINATI PER NOME
    @GetMapping("/nome/")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    public ResponseEntity<Page<Utente>> getByNome( Pageable p ) {
        return new ResponseEntity<Allenatore>(
                allenatoreService.getByNome( p ),
                HttpStatus.OK
        );
    }

    // RITORNA UNA LISTA DEGLI ALLENATORI FILTRATI PER NOME E COGNOME
    @GetMapping("/filter-nome-cognome/{nome}/{cognome}")
    @PreAuthorize("hasAnyRole('ALLENATORE','UTENTE')")
    public ResponseEntity<Page<Allenatore>> filterByNomeECognome( @PathVariable("nome") String nome,
                                                              @PathVariable("cognome") String cognome,
                                                              Pageable p ) {
        return new ResponseEntity<>(
                allenatoreService.filterByNomeECognome( nome, cognome, p ),
                HttpStatus.OK
        );
    }

}
