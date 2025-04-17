package com.tienda.tiendauniversitaria.controller;

import com.tienda.tiendauniversitaria.model.Pedido;
import com.tienda.tiendauniversitaria.service.ColaPrioridadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*") // permite llamadas desde frontend
public class PedidoController {

    private final ColaPrioridadService service;
    public PedidoController(ColaPrioridadService service) {
        this.service = service;
    }

    @PostMapping
    public void agregar(@RequestBody Pedido pedido) {
        service.agregarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listar() {
        return service.listarPedidos();
    }

    @DeleteMapping("/atender")
    public Pedido atender() {
        return service.atenderPedido();
    }
}