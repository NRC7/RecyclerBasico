package com.nrc7.ayudantiarv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazo en recyclerview
        recyclerView = findViewById(R.id.rv);

        // Recibir la lista
        //List<Book> bookList = new Book().getAllBooks();
        // Recibir lista desde DataSource
        List<Book> bookList = new DataSource().getAllBooks();

        // Crear el adapter
        BookAdapter bookAdapter = new BookAdapter(bookList);

        // Enlazar recycler con adapter
        recyclerView.setAdapter(bookAdapter);

        // Implementar el click listener del bloque ViewHolder
        bookAdapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void itemClick(Book book) {
                Toast.makeText(MainActivity.this, book.getNombre(), Toast.LENGTH_SHORT).show();

                // abrir el nuevo fragmento
                // Pasarle el book
                // Cerrar el fragmento de lista
            }
        });

    }
}