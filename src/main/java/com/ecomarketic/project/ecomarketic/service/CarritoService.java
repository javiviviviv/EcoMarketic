package com.ecomarketic.project.ecomarketic.service;

import com.ecomarketic.project.ecomarketic.model.Carrito;
import com.ecomarketic.project.ecomarketic.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> getAll() {
        return carritoRepository.findAll();
    }

    public Carrito getById(Integer id) {
        Optional<Carrito> carrito = carritoRepository.findById(Long.valueOf(id));
        return carrito.orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado: " + id));
    }

    public Carrito create(Carrito carrito) {
        carrito.setFecha(new Date());
        carrito.setEstado("activo");
        return carritoRepository.save(carrito);
    }

    public Carrito update(Integer id, Carrito updatedCarrito) {
        Carrito existingCarrito = getById(id);
        if (existingCarrito != null) {
            updatedCarrito.setId(id);
            return carritoRepository.save(updatedCarrito);
        }
        return null;
    }

    public void delete(Integer id) {
        carritoRepository.deleteById(Long.valueOf(id));
    }
}
