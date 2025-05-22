package com.ecomarketic.project.ecomarketic.controller;

import com.ecomarketic.project.ecomarketic.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import com.ecomarketic.project.ecomarketic.model.Carrito;
import com.ecomarketic.project.ecomarketic.model.Cliente;
import com.ecomarketic.project.ecomarketic.model.Producto;
import com.ecomarketic.project.ecomarketic.services.CarritoService;
import com.ecomarketic.project.ecomarketic.services.ClienteService;
import com.ecomarketic.project.ecomarketic.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ecomarketic")
public class EcoMarketicController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ProductoService productoService;

    // Obtener todos los carritos de un cliente por ID
    @GetMapping("/cliente/{clienteId}/carritos")
    public List<Carrito> getCarritosByClienteId(@PathVariable Integer clienteId) {
        return carritoService.getAll()
                .stream()
                .filter(carrito -> carrito.getCliente() != null && carrito.getCliente().getId().equals(clienteId))
                .collect(Collectors.toList());
    }

    @GetMapping("/productos/categoria/{categoria}")
    public List<Producto> getProductosByCategoria(@PathVariable String categoria) {
        return productoService.getAll()
                .stream()
                .filter(producto -> producto.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    @GetMapping("/productos/nombre/{nombre}")
    public List<Producto> getProductosByNombre(@PathVariable String nombre) {
        return productoService.getAll()
                .stream()
                .filter(producto -> producto.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    @GetMapping("/clientes/con-carritos-activos")
    public List<Cliente> getClientesConCarritosActivos() {
        return carritoService.getAll()
                .stream()
                .filter(carrito -> "activo".equalsIgnoreCase(carrito.getEstado()))
                .map(Carrito::getCliente)
                .distinct()
                .collect(Collectors.toList());
    }
}
