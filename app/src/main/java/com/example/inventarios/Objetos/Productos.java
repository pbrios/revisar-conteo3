package com.example.inventarios.Objetos;

import java.io.Serializable;

public class Productos implements Serializable {
    private String codigo;
    private String descripcion;
    private String unidades;
    private String cantidad;

    public Productos(){}

    public Productos(String codigo, String descripcion, String unidades, String cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.cantidad = cantidad;
    }

    public Productos(String codigo, String descripcion, String unidades) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidades = unidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUnidades() {
        return unidades;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", unidades='" + unidades + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}
