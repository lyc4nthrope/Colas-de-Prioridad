package com.tienda.tiendauniversitaria.model;

public class Pedido {
    private String nombre;
    private String rol;
    private int prioridad; // 1 = discapacidad, 2 = profesor, 3 = estudiante

    public Pedido() {}

    public Pedido(String nombre, String rol, int prioridad) {
        this.nombre = nombre;
        this.rol = rol;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}