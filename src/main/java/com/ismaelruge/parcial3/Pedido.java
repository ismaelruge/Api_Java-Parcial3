package com.ismaelruge.parcial3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private int idPedido;
    private LocalDateTime fecha;
    private String cliente;
    private double total;
    private String estado;
}