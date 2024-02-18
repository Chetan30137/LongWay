package com.example.item_cart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Next_item_cart extends AppCompatActivity {
    RecyclerView mycart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_item_cart);
        mycart=findViewById(R.id._my_cart);

        List<Product> cartP = new ArrayList<>();

        cartP.add(new Product("Borbon","5","50"));
        cartP.add(new Product("50-50","5","50"));
        cartP.add(new Product("Oreo","5","50"));
        cartP.add(new Product("Treat","5","50"));

        CartAdapter adapter= new CartAdapter(Next_item_cart.this,cartP);
        mycart.setAdapter(adapter);
        // adapter.notifyDataSetChanged();
        mycart.setLayoutManager(new LinearLayoutManager(this));


    }
}