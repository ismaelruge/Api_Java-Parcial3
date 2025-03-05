package com.ismaelruge.parcial3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidoService;

    // Obtener todos los pedidos
    @GetMapping
    public Flux<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.listarPedidos();
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public Mono<Pedido> obtenerPedidoPorId(@PathVariable int id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    // Crear un nuevo pedido
    @PostMapping
    public Mono<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    // Actualizar un pedido por ID
    @PutMapping("/{id}")
    public Mono<Pedido> actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        return pedidoService.actualizarPedido(id, pedido);
    }

    // Eliminar un pedido por ID
    @DeleteMapping("/{id}")
    public Mono<Void> eliminarPedido(@PathVariable int id) {
        return pedidoService.eliminarPedido(id);
    }
}
