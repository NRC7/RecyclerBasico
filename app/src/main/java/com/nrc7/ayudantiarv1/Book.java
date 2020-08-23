package com.nrc7.ayudantiarv1;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String id, nombre, autor;

    public Book(String id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Generar una lista de libros
    public List<Book> getAllBooks() {

        List<Book> libros = new ArrayList<>();

        for (int i = 1; i <=50 ; i++) {
            libros.add(new Book(String.valueOf(i),"Libro " + i,"Autor " + i));
        }

        return libros;
    }
}
