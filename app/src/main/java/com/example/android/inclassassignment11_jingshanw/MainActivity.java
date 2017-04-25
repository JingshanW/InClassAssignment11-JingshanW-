package com.example.android.inclassassignment11_jingshanw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    private DatabaseReference bookReference = FirebaseDatabase.getInstance().getReference("book");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookAdapter = new BookAdapter(bookReference);

        recyclerView.setAdapter(bookAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bookAdapter.cleanup(); // Stop listening if the activity is destroyed
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void addBook(MenuItem item) {
        Intent intent=new Intent(this,EditActivity.class);
        startActivity(intent);
    }

//    public void addBook(View view) {
//        String id = UUID.randomUUID().toString();
//        Random random = new Random();
//        bookReference.child(id).setValue(new Book("Scarlet Letter", random.nextInt(100), random.nextBoolean()));
//    }
}


