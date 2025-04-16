package com.tienda.tiendauniversitaria.Controller;

import com.tienda.tiendauniversitaria.model.Pedido;
import com.tienda.tiendauniversitaria.service.ColaPrioridad;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ColaPrioridad cola = new ColaPrioridad();


    @PostMapping("/nuevo")
    public String nuevoPedido(@RequestParam String nombre, @RequestParam String rol){
        Pedido pedido = new Pedido(nombre, rol);
        cola.agregarPedido(pedido);
        return "Pedido agregado: " + pedido;
    }

    @GetMapping("/atender")
    public String atender(){
        Pedido p = cola.atenderPedido();
        return (p != null) ? "Atendiendo a: " + p : "No hay pedidos";
    }

    @GetMapping("/cola")
    public List<Pedido> mostrarCola(){
        return cola.verCola();
    }
}
