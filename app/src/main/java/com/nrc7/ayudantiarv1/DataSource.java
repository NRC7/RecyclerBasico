package com.nrc7.ayudantiarv1;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public DataSource() {
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
