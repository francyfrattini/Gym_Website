package com.francesca.frattini.gymwebsite.repositories;

import com.francesca.frattini.gymwebsite.entities.Allenatore;
import com.francesca.frattini.gymwebsite.entities.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AllenatoreRepository extends JpaRepository<Allenatore, Long> {

    /////////////////////////////////////////////////////////////
    ///////////////////////// ORDER BY /////////////////////////
    /////////////////////////////////////////////////////////////
    @Query(
            value = "select a from Allenatore a order by a.nome asc"
    )
    Page<Allenatore> findByNome(Pageable pageable );

    //---------------------------------FINE--------------------------------------------//

    /////////////////////////////////////////////////////////////
    ///////////////////////// FILTER BY /////////////////////////
    /////////////////////////////////////////////////////////////

    @Query(
            value = "select a from Allenatore a where upper(a.nome) like upper(concat('%', :nome, "
                    + "'%')) and upper(a.cognome) like upper(concat('%', :cognome, '%') )"
    )
    Page<Allenatore> filterByNomeECognome(@Param("nome") String nome, @Param("cognome") String cognome, Pageable pageable );

    @Query(
            value = "select a from Allenatore a where a.user.id = :id"
    )
    List<Allenatore> findAllenatoreByUserId(@Param( "id" ) Long id);

    Page<Allenatore> findAll(Pageable p);
}
