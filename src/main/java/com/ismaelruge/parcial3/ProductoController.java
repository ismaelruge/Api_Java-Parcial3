package com.ismaelruge.parcial3;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Flux<Producto> listarProductos() {
        return productoService.obtenerProductos();
    }
}