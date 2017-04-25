package com.example.android.inclassassignment11_jingshanw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.UUID;

public class EditActivity extends AppCompatActivity {


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference bookReference=database.getReference("book");

    private TextView bookName;
    private TextView bookPrice;
    private CheckBox inStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        bookName= (TextView) findViewById(R.id.book_name_textview);
        bookPrice= (TextView) findViewById(R.id.book_price_textview);
        inStock= (CheckBox) findViewById(R.id.in_stock_checkbox);

        Intent intent=getIntent();
        String name=intent.getStringExtra("NAME");
        bookName.setText(name);
        String price=intent.getStringExtra("PRICE");
        bookPrice.setText(price);
        String instock=intent.getStringExtra("INSTOCK");
        if(instock=="true"){
            inStock.isChecked();
        }
        else{}


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void saveBook(MenuItem item) {
        String id=bookName.getText().toString();
//        String id = UUID.randomUUID().toString();
//        Random random = new Random();
        Book b=new Book(bookName.getText().toString(),Integer.parseInt(bookPrice.getText().toString()),inStock.isChecked());
        bookReference.child(id).setValue(b);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void delete(MenuItem item) {
        String id=bookName.getText().toString();
//        String id = UUID.randomUUID().toString();
//        Random random = new Random();
        bookReference.child(id).removeValue();

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
