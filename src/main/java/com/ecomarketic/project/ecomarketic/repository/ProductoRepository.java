package com.ecomarketic.project.ecomarketic.repository;

import java.util.List;
import com.ecomarketic.project.ecomarketic.*;
import com.ecomarketic.project.ecomarketic.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombre(String nombre);

    List<Producto> findByCategoria(String categoria);


}
