package com.francesca.frattini.gymwebsite.repositories;

import com.francesca.frattini.gymwebsite.entities.Role;
import com.francesca.frattini.gymwebsite.entities.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);

    Page<Role> findAll(Pageable p);
}
