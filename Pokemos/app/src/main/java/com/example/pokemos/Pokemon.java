package com.example.pokemos;

public class Pokemon {
    String numero;
    String nombre;
    String url;

    public Pokemon(String numero, String nombre, String url) {
        this.numero = numero;
        this.nombre = nombre;
        this.url = url;
    }

    public String  getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
