package com.example.item_cart;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private List<String> myList;
    private Activity activity;

    public Adapter(List<String> myList, Activity activity) {
        this.myList = myList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_items, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        String name = myList.get(position);
        holder.item_name.setText(name);

        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(holder.quantity.getText().toString());
                Log.d("test",String.valueOf(count));
                if(count > 0)
                    holder.quantity.setText(String.valueOf(count - 1));
            }
        });
        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counta=Integer.parseInt(holder.quantity.getText().toString());
                Log.d("test",String.valueOf((counta)));
                if(counta>=0){
                    holder.quantity.setText(String.valueOf(counta+1));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        Button decrement,b2,b3,b4,increment;
        TextView tv1,tv2,tv3,tv4;
        EditText quantity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById((R.id._item_name));
            tv1=itemView.findViewById(R.id._item_name);
            tv2=itemView.findViewById(R.id._item_description);
            decrement=itemView.findViewById(R.id._item_decrement);
            increment=itemView.findViewById(R.id._item_increment);
            quantity=itemView.findViewById(R.id._item_quantity);
            b2=itemView.findViewById(R.id._item_increment);
            tv3=itemView.findViewById(R.id._item_price);
            tv4=itemView.findViewById(R.id._item_Totalprice);
            b3=itemView.findViewById(R.id._item_cancel_button);
            b4=itemView.findViewById(R.id._item_add_button);
        }
    }
}
