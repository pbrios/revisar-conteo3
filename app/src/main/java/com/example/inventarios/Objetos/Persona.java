package com.example.inventarios.Objetos;

import java.io.Serializable;

public class Persona  implements Serializable {
    private String name;
    private String id;
    private String idAlmacen;
    private String idSucursal;

    public Persona(){

    }

    public Persona(String name, String id, String idAlmacen, String idSucursal) {
        this.name = name;
        this.id = id;
        this.idAlmacen = idAlmacen;
        this.idSucursal = idSucursal;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getNombre() {
        return name;
    }

    public String getIdUsuario() {
        return id;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + name + '\'' +
                ", idUsuario='" + id + '\'' +
                ", idAlmacen='" + idAlmacen + '\'' +
                ", idSucursal='" + idSucursal + '\'' +
                '}';
    }
}
