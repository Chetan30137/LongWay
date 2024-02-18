package com.example.item_cart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    RecyclerView item_view_list;
    DatabaseReference reference;
    List<String> myItemList;

    FirebaseDatabase database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("ItemList");
        Log.d("MainActivity",""+reference);;
        item_view_list = findViewById(R.id._my_item_view);

        myItemList = new ArrayList<>();
        Adapter myAdapter = new Adapter(myItemList,DisplayActivity.this);
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("MainActivity",""+snapshot);
                Log.d("MainActivity",""+snapshot.getChildrenCount());
                for(DataSnapshot itemSnapshot : snapshot.getChildren()){
                    Product product = itemSnapshot.getValue(Product.class);
                    Log.d("MainActivity",product.getIname());
                    myItemList.add(product.getIname());
                    Log.d("Test",myItemList.toString());
                    myAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //String [] list = {"Apple","Mango","PineApple","Guava","Banana"};


        item_view_list.setAdapter(myAdapter);
        item_view_list.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_menu_bar, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id._added_cart:
                Intent intent=new Intent(DisplayActivity.this,Next_item_cart.class);
                startActivity(intent);
                return true;
            case R.id._bookmark:

                return true;
            case R.id._profile:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}