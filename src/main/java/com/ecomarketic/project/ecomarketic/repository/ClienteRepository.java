package com.ecomarketic.project.ecomarketic.repository;

import java.util.List;
import com.ecomarketic.project.ecomarketic.*;
import com.ecomarketic.project.ecomarketic.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombre(String nombre);



}
