package com.nrc7.ayudantiarv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private List<Book> bookList;
    private OnItemClickListener listener;

    // Le entrego la lista al adapter
    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    // METODOS DEL ADAPTER
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        // Tengo cada elemento por separado
        Book book = bookList.get(position);
        // Completar cada TextView
        holder.id.setText(book.getId());
        holder.name.setText(book.getNombre());
        holder.author.setText(book.getAutor());
    }

    // Le dice al adapter cuantos elementos totales debe contener
    @Override
    public int getItemCount() {
        // .size() : entrega el numero total de elementos
        return bookList.size();
    }

    // Creacion de la interface
    public interface OnItemClickListener {
        // Pasar el indice del elemento clickeado
        // void itemClick(int position);
        // Pasar el elemento clickeado
         void itemClick(Book book);
    }

    // El metodo para utilizar el click listener desde fuera
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // VIEWHOLDER: REPRESENTACION DE 1 REGISTRO / BLOQUE
    public class BookViewHolder extends RecyclerView.ViewHolder {

            // Vistas del book_list_item
            TextView id,name,author;

            public BookViewHolder(@NonNull View itemView) {
                super(itemView);

                id = itemView.findViewById(R.id.idTv);
                name = itemView.findViewById(R.id.nameTv);
                author = itemView.findViewById(R.id.authorTv);

                // EVENTO ON CLICK DEL BLOQUE
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Traer al elemento clickeado
                        Book bookClieckeado = bookList.get(getAdapterPosition());
                        // Entregar el elemento al listener
                        listener.itemClick(bookClieckeado);
                    }
                });
            }
    }
    // Fin ViewHolder
}
