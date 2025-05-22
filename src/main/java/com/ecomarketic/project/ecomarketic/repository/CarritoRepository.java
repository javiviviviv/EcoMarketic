package com.ecomarketic.project.ecomarketic.repository;

import com.ecomarketic.project.ecomarketic.*;
import com.ecomarketic.project.ecomarketic.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    List<Carrito> findCarritoById(Integer Id);

    
}
