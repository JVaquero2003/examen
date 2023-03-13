package com.examen.examen.Model;

public class Alumno {

    private int id;
    private String nombre;
    private String fct;

    public Alumno(int id, String nombre, String fct) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.fct = fct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }

}
