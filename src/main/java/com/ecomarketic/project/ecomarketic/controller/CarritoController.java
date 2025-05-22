package com.ecomarketic.project.ecomarketic.controller;

import com.ecomarketic.project.ecomarketic.model.Carrito;
import com.ecomarketic.project.ecomarketic.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoService.getAll();
    }

    @GetMapping("/{id}")
    public Carrito getCarritoById(@PathVariable Integer id) {
        return carritoService.getById(id);
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoService.create(carrito);
    }

    @PutMapping("/{id}")
    public Carrito updateCarrito(@PathVariable Integer id, @RequestBody Carrito carrito) {
        return carritoService.update(id, carrito);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable Integer id) {
        carritoService.delete(id);
    }
}
