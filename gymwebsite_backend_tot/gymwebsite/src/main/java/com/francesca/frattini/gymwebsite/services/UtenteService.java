package com.francesca.frattini.gymwebsite.services;

import com.francesca.frattini.gymwebsite.entities.Utente;
import com.francesca.frattini.gymwebsite.repositories.AllenatoreRepository;
import com.francesca.frattini.gymwebsite.repositories.UtenteRepository;
import com.francesca.frattini.gymwebsite.utilsRequestModels.UtenteRequest;
import com.francesca.frattini.gymwebsite.utilsResponseModels.UtenteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    // GETALL
    public List<Utente> getAll() {
        return utenteRepository.findAll();
    }

    public Page<Utente> getAllPaginate(Pageable p ) {
        return utenteRepository.findAll( p );
    }

    // GET BY ID
    public Utente getById( Long id ) throws Exception {
        Optional<Utente> utente = utenteRepository.findById( id );
        if( utente.isEmpty() )
            throw new Exception( "Utente non trovato" );
        return utente.get();
    }

    // CREATE AND SAVE
    public UtenteResponse createAndSave(UtenteRequest utenteRequest ) throws Exception {

        Utente utente = Utente.builder()
                .utenteId( utenteRequest.getUtenteId() )
                .email( utenteRequest.getEmail() )
                .nome( utenteRequest.getNome() )
                .cognome( utenteRequest.getCognome() )
                .telefono( utenteRequest.getTelefono() )
                .dataIscrizione( LocalDate.now() )
                .build();

        utenteRepository.save( utente );

        return UtenteResponse.parseUtente( utente );
    }

    // CREATE
    public void save( Utente utente ) {
        utenteRepository.save( utente );
    }

    public UtenteResponse updateResponse( UtenteRequest utenteRequest, Long id ) throws Exception {
        Optional<Utente> utenteFind = utenteRepository.findById( id );

        if( utenteFind.isPresent() ) {
            Utente u = new Utente();
            u.setUtenteId( id );
            u.setEmail( utenteRequest.getEmail() == null ? utenteFind.get().getEmail() : utenteRequest.getEmail() );
            u.setNome( utenteRequest.getNome() == null ? utenteFind.get().getNome() :
                    utenteRequest.getNome() );
            u.setCognome( utenteRequest.getCognome() == null ?
                    utenteFind.get().getCognome() : utenteRequest.getCognome() );
            u.setTelefono( utenteRequest.getTelefono() == null ?
                    utenteFind.get().getTelefono() : utenteRequest.getTelefono() );
            u.setDataIscrizione( utenteFind.get().getDataIscrizione() );

            utenteRepository.save( u );
            return UtenteResponse.parseUtente( utenteFind.get() );
        } else {
            return null;
        }
    }

    // UPDATE
    public void update( Utente utente ) {
        utenteRepository.save( utente );
    }

    // DELETE
    public void delete( Long id ) throws Exception {
        Optional<Utente> utente = utenteRepository.findById( id );
        if( utente.isPresent() ) {
            utenteRepository.delete( utente.get() );
        } else {
            throw new Exception( "Utente non trovato" );
        }
    }

    ///////////////////////// QUERY PERSONALIZZATE/////////////////////////
    ///////////////////////////////////////////////////////////////////////


    ///////////////////////////////////// ORDER BY /////////////////////////////////

    // GET BY NOME CONTATTO
    public Page<Utente> getByNome( Pageable p ) {
        return utenteRepository.findByNome( p );
    }

    // GET BY DATA ISCRIZIONE
    public Page<Utente> getByDataIscrizione( Pageable p ) {
        return utenteRepository.findByDataIscrizione( p );
    }

    ////////////////////////////// FILTER BY //////////////////////////////////

    // GET BY DATA INSERIMENTO PARAM
    public Page<Utente> filterByDataIscrizione( LocalDate dataIscrizione, Pageable p ) {
        return utenteRepository.filterByDataIscrizione( dataIscrizione, p );
    }

    // GET BY NOME E COGNOME PARAMS
    public Page<Utente> filterByNomeECognome( String nome, String cognome, Pageable p ) {
        return utenteRepository.filterByNomeECognome( nome, cognome, p );
    }


}
