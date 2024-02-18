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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Cartholder> {
    Activity activity;
    List<Product> my_list;

    public CartAdapter(Activity activity, List<Product> my_list) {
        this.activity = activity;
        this.my_list = my_list;
        Log.d("List size",""+my_list.size());
    }

    @NonNull
    @Override
    public CartAdapter.Cartholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_items,parent,false);
        Cartholder holder=new Cartholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Cartholder holder, int position) {
        Product p= my_list.get(position);
        holder.cart_name.setText(p.getIname());
        holder.cart_quantity.setText(p.getIquantity());
        holder.cart_price.setText(p.getIcost());
    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    public class Cartholder extends RecyclerView.ViewHolder {
        TextView cart_name;
        EditText cart_quantity,cart_price;
        Button remove;

        public Cartholder(@NonNull View itemView) {
            super(itemView);

            cart_name=itemView.findViewById(R.id._item_cart_name);
            cart_quantity=itemView.findViewById(R.id._item_cart_quan_e);
            cart_price= itemView.findViewById(R.id._item_cart_p_e);
            remove=itemView.findViewById(R.id._item_cart_remove_b);
        }
    }
}
