package com.tienda.tiendauniversitaria.model;

import java.util.Locale;

public class Pedido {
    private String nombre;
    private String rol;
    private int prioridad;

    public Pedido(String nombre, String rol) {
        this.nombre = nombre;
        this.prioridad = asignarPrioridad(rol);
        this.rol = rol;
    }

    private int asignarPrioridad(String rol){
        return switch (rol.toLowerCase()){
            case "profesor" -> 1;
            case "administrativo" -> 2;
            case "estudiante" -> 3;
            default -> 4;
        };
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

    @Override
    public String toString() {
        return "Pedido{" +
                "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}

