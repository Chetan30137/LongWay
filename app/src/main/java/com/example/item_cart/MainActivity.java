package com.example.item_cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText ina,inumb,ides,iwei,iqua,icos;
    Button sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ina=findViewById(R.id._itemName);
        inumb=findViewById(R.id._itemNumb);
        ides=findViewById(R.id._itemDescription);
        iwei=findViewById(R.id._itemWeight);
        iqua=findViewById(R.id._itemQuantity);
        icos=findViewById(R.id._itemCost);
        sa=findViewById(R.id._sac);
        FirebaseApp.initializeApp(MainActivity.this);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myreff=database.getReference("ItemList");
        Log.d("MainActivity",""+database);
        Log.d("MainActivity",""+myreff);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myreff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.d("MainActivity-Listener",""+snapshot);
                        long l=snapshot.getChildrenCount();
                        Log.d("MainActivity",""+snapshot.getChildrenCount());
                        String iname=ina.getText().toString();
                        String idescreption=ides.getText().toString();
                        String inumber=inumb.getText().toString();
                        String iweight=iwei.getText().toString();
                        String iquantity=iqua.getText().toString();
                        String icost=icos.getText().toString();
                        Product ip=new Product(iname,idescreption,inumber,iweight,iquantity,icost);
                        myreff.child(String.valueOf(l)).setValue(ip);
                        Toast.makeText(MainActivity.this, "Saved the item in your Cart", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("MainActivity",""+error);
                    }
                });
                Intent myIntent = new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(myIntent);
                finish();
            }


        });



    }
}