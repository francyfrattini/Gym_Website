package com.francesca.frattini.gymwebsite.services;

import com.francesca.frattini.gymwebsite.entities.Allenamenti;
import com.francesca.frattini.gymwebsite.entities.Allenatore;
import com.francesca.frattini.gymwebsite.entities.Utente;
import com.francesca.frattini.gymwebsite.repositories.AllenatoreRepository;
import com.francesca.frattini.gymwebsite.repositories.UtenteRepository;
import com.francesca.frattini.gymwebsite.utils.AllenamentiParser;
import com.francesca.frattini.gymwebsite.utilsRequestModels.AllenatoreRequest;
import com.francesca.frattini.gymwebsite.utilsResponseModels.AllenatoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class AllenatoreService {

    @Autowired
    AllenatoreRepository allenatoreRepository;

    // GETALL
    public List<Allenatore> getAll() {
        return allenatoreRepository.findAll();
    }

    public Page<Allenatore> getAllPaginate(Pageable p ) {
        return allenatoreRepository.findAll( p );
    }

    // GET BY ID
    public Allenatore getById( Long id ) throws Exception {
        Optional<Allenatore> allenatore = allenatoreRepository.findById( id );
        if( allenatore.isEmpty() )
            throw new Exception( "Allenatore non trovato" );
        return allenatore.get();
    }

    // CREATE AND SAVE
    public AllenatoreResponse createAndSave(AllenatoreRequest allenatoreRequest ) throws Exception {

        Allenatore allenatore = Allenatore.builder()
                .allenatoreId( allenatoreRequest.getAllenatoreId() )
                .email( allenatoreRequest.getEmail() )
                .nome( allenatoreRequest.getNome() )
                .cognome( allenatoreRequest.getCognome() )
                .telefono( allenatoreRequest.getTelefono() )
                .allenamenti( AllenamentiParser.parse( allenatoreRequest.getAllenamenti() ) )
                .build();

        allenatoreRepository.save( allenatore );

        return AllenatoreResponse.parseAllenatore( allenatore );
    }

    // CREATE
    public void save( Allenatore allenatore ) {
        allenatoreRepository.save( allenatore );
    }

    public AllenatoreResponse updateResponse( AllenatoreRequest allenatoreRequest, Long id ) throws Exception {
        Optional<Allenatore> allenatoreFind = allenatoreRepository.findById( id );

        if( allenatoreFind.isPresent() ) {
            Allenatore a = new Allenatore();
            a.setAllenatoreId( id );
            a.setEmail( allenatoreRequest.getEmail() == null ? allenatoreFind.get().getEmail() : allenatoreRequest.getEmail() );
            a.setNome( allenatoreRequest.getNome() == null ? allenatoreFind.get().getNome() :
                    allenatoreRequest.getNome() );
            a.setCognome( allenatoreRequest.getCognome() == null ?
                    allenatoreFind.get().getCognome() : allenatoreRequest.getCognome() );
            a.setTelefono( allenatoreRequest.getTelefono() == null ?
                    allenatoreFind.get().getTelefono() : allenatoreRequest.getTelefono() );
            a.setAllenamenti( allenatoreRequest.getAllenamenti() == null ? allenatoreFind.get().getAllenamenti() :
                    Allenamenti.valueOf( allenatoreRequest.getAllenamenti() ) );

            allenatoreRepository.save( a );
            return AllenatoreResponse.parseAllenatore( allenatoreFind.get() );
        } else {
            return null;
        }
    }

    // UPDATE
    public void update( Allenatore allenatore ) {
        allenatoreRepository.save( allenatore );
    }

    // DELETE
    public void delete( Long id ) throws Exception {
        Optional<Allenatore> allenatore = allenatoreRepository.findById( id );
        if( allenatore.isPresent() ) {
            allenatoreRepository.delete( allenatore.get() );
        } else {
            throw new Exception( "Allenatore non trovato" );
        }
    }

    ///////////////////////// QUERY PERSONALIZZATE/////////////////////////
    ///////////////////////////////////////////////////////////////////////


    ///////////////////////////////////// ORDER BY /////////////////////////////////

    // GET BY NOME CONTATTO
    public Page<Allenatore> getByNome( Pageable p ) {
        return allenatoreRepository.findByNome( p );
    }

    ////////////////////////////// FILTER BY //////////////////////////////////

    // GET BY NOME E COGNOME PARAMS
    public Page<Allenatore> filterByNomeECognome(String nome, String cognome, Pageable p ) {
        return allenatoreRepository.filterByNomeECognome( nome, cognome, p );
    }


}

