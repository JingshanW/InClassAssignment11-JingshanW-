package com.example.android.inclassassignment11_jingshanw;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BookViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView bookNameText;
    private TextView bookPriceText;
    private TextView inStockText;
    private Context context;

    public BookViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        bookNameText = (TextView) itemView.findViewById(R.id.book_name);
        bookPriceText = (TextView) itemView.findViewById(R.id.book_price);
        inStockText = (TextView) itemView.findViewById(R.id.book_instock);
        this.context = itemView.getContext();
    }

    public void bind(final Book book) {
        bookNameText.setText(book.name);
        bookPriceText.setText("Price: " + book.price);
        inStockText.setText("In Stock: " + book.inStock);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, bookNameText.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}


