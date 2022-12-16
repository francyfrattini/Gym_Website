package com.francesca.frattini.gymwebsite.services;

import com.francesca.frattini.gymwebsite.entities.Role;
import com.francesca.frattini.gymwebsite.entities.RoleType;
import com.francesca.frattini.gymwebsite.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository repository;

    // GET BY ID
    public Role getById(Long id) throws Exception {
        Optional<Role> ba = repository.findById(id);
        if ( ba.isEmpty() )
            throw new Exception("Ruolo non trovato");
        return ba.get();
    }

    // GET BY ROLE
    public Role getByRole( RoleType roleType) throws Exception {
        Optional<Role> ba = repository.findByRoleType(roleType);
        if ( ba.isEmpty() )
            throw new Exception("Ruolo non trovato");
        return ba.get();
    }

    // GET ALL PAGEABLE
    public Page<Role> getAllPaginate(Pageable p) {
        return repository.findAll(p);
    }

    // GET ALL
    public List<Role> getAll() {
        return repository.findAll();
    }

    // CREATE
    public Role save( Role x) {
        return repository.save(x);
    }

    // DELETE
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
