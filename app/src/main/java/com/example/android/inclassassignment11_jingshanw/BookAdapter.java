package com.example.android.inclassassignment11_jingshanw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

public class BookAdapter extends FirebaseRecyclerAdapter<Book, BookViewHolder> {

    public BookAdapter(Query ref) {
        super(Book.class, R.layout.card_view_book, BookViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(BookViewHolder viewHolder, Book book, int position) {
        viewHolder.bind(book);
    }
}
