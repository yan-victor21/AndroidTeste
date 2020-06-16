package com.example.testejava.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testejava.R;
import com.example.testejava.model.Product;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

public class Adapter extends BaseAdapter {
    private final List<Product> products;
    private final Activity act;

    public Adapter(List<Product> products, Activity act) {
        this.products = products;
        this.act = act;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) { return products.get(position); }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_product,parent,false);
        Product product = products.get(position);
        NumberFormat nf =NumberFormat.getCurrencyInstance();

        TextView name = (TextView)view.findViewById(R.id.name_item);
        TextView stock = (TextView)view.findViewById(R.id.stock_item);
        TextView price = (TextView)view.findViewById(R.id.price_item);
        ImageView image = (ImageView)view.findViewById(R.id.image_item);
        name.setText(product.getName());
        if(product.getStock()>1){
            stock.setText("in stock");
        }else if(product.getStock() == 1){
            stock.setText("only 1 left in stock");
        }

        price.setText(String.valueOf(nf.format(product.getPrice())));

        Picasso.get().load(product.getImage_url()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(image,new com.squareup.picasso.Callback(){@Override public void onSuccess(){} @Override public void onError(Exception e) {}});

        return view;
    }
}
