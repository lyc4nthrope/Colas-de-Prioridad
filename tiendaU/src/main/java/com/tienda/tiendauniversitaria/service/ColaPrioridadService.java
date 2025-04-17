package com.tienda.tiendauniversitaria.service;

import com.tienda.tiendauniversitaria.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ColaPrioridadService {
    private final LinkedList<Pedido> cola = new LinkedList<>();

    public void agregarPedido(Pedido p) {
        int i = 0;
        // inserta ordenado según prioridad: menor valor = mayor prioridad
        while (i < cola.size() && p.getPrioridad() >= cola.get(i).getPrioridad()) {
            i++;
        }
        cola.add(i, p);
    }

    public Pedido atenderPedido() {
        return cola.isEmpty() ? null : cola.removeFirst();
    }

    public List<Pedido> listarPedidos() {
        return new LinkedList<>(cola);
    }
}