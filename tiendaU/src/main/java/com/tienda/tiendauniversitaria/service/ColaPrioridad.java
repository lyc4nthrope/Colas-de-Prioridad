package com.tienda.tiendauniversitaria.service;

import com.tienda.tiendauniversitaria.model.Pedido;

import java.util.LinkedList;
import java.util.List;

public class ColaPrioridad {
    private List<Pedido> cola;

    public ColaPrioridad() {
        this.cola = new LinkedList<>();
    }

    public void agregarPedido(Pedido pedido){//encolar
        int i=0;
        while (i < cola.size() && pedido.getPrioridad() >= cola.get(i).getPrioridad()){
            i++;
        }
        cola.add(i, pedido);
    }

    public Pedido atenderPedido(){//desencolar
        if (cola.isEmpty()){
            return null;
        }
        return cola.remove(0);
    }

    public List<Pedido> verCola(){//ver la cola
        return cola;
    }
}
