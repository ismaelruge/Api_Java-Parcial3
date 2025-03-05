package com.ismaelruge.parcial3;

import org.springframework.stereotype.Service;

import java.util.List;
import reactor.core.publisher.Flux;

@Service
public class ProductoService {

    private List<Producto> productos = List.of(
      new Producto("1", "Laptop", 1200.0),
      new Producto("2", "Mouse", 25.0),
      new Producto("3", "Teclado", 45.0)
    );

    public Flux<Producto> obtenerProductos() {
        return Flux.fromIterable(productos);
    }
}
