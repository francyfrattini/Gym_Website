package com.francesca.frattini.gymwebsite.repositories;

import com.francesca.frattini.gymwebsite.entities.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    /////////////////////////////////////////////////////////////
    ///////////////////////// ORDER BY /////////////////////////
    /////////////////////////////////////////////////////////////
    @Query(
            value = "select u from Utente u order by u.nome asc"
    )
    Page<Utente> findByNome(Pageable pageable );

    @Query("select u from Utente u order by c.dataIscrizione asc"
    )
    Page<Utente> findByDataIscrizione( Pageable pageable );

    //---------------------------------FINE--------------------------------------------//

    /////////////////////////////////////////////////////////////
    ///////////////////////// FILTER BY /////////////////////////
    /////////////////////////////////////////////////////////////
    @Query("select u from Utente u where u.dataIscrizione=:param"
    )
    Page<Utente> filterByDataIscrizione(@Param("param") LocalDate dataIscrizione, Pageable pageable );

    @Query(
            value = "select u from Utente u where upper(u.nome) like upper(concat('%', :nome, "
                    + "'%')) and upper(u.cognome) like upper(concat('%', :cognome, '%') )"
    )
    Page<Utente> filterByNomeECognome(@Param("nome") String nome, @Param("cognome") String cognome, Pageable pageable );

    @Query(
            value = "select u from Utente u where u.user.id = :id"
    )
    List<Utente> findUtenteByUserId(@Param( "id" ) Long id);

    Page<Utente> findAll(Pageable p);

    Optional<Utente> findByUsername(String username);
}
