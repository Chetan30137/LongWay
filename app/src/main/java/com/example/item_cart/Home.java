package com.example.item_cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void gotoDisplay(View view) {
        Intent intent= new Intent(Home.this,DisplayActivity.class);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id._added_cart:
                Intent intent=new Intent(Home.this,Next_item_cart.class);
                startActivity(intent);
                Log.d("MainActivity","clicked to cart");
                return true;
            case R.id._bookmark:
                intent=new Intent(Home.this,MainActivity.class);
                startActivity(intent);
                Log.d("MainActivity","clicked bookmark");
                return true;
            case R.id._profile:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}