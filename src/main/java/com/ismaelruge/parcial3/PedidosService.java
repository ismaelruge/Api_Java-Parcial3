package com.ismaelruge.parcial3;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PedidosService {

    private final List<Pedido> pedidos = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(1); // Generador de ID automático

    // Listar todos los pedidos
    public Flux<Pedido> listarPedidos() {
        return Flux.fromIterable(pedidos);
    }

    // Buscar pedido por ID
    public Mono<Pedido> obtenerPedidoPorId(int id) {
        return Mono.justOrEmpty(pedidos.stream()
                .filter(pedido -> pedido.getIdPedido() == id)
                .findFirst());
    }

    // Guardar un nuevo pedido
    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedido.setIdPedido(contadorId.getAndIncrement()); // Asigna un ID único
        pedido.setFecha(LocalDateTime.now()); // Fecha automática
        pedidos.add(pedido);
        return Mono.just(pedido);
    }

    // Actualizar un pedido existente
    public Mono<Pedido> actualizarPedido(int id, Pedido pedidoActualizado) {
        Optional<Pedido> pedidoExistente = pedidos.stream()
                .filter(p -> p.getIdPedido() == id)
                .findFirst();

        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setCliente(pedidoActualizado.getCliente());
            pedido.setTotal(pedidoActualizado.getTotal());
            pedido.setEstado(pedidoActualizado.getEstado());
            return Mono.just(pedido);
        } else {
            return Mono.empty();
        }
    }

    // Eliminar un pedido por ID
    public Mono<Void> eliminarPedido(int id) {
        pedidos.removeIf(pedido -> pedido.getIdPedido() == id);
        return Mono.empty();
    }
}
