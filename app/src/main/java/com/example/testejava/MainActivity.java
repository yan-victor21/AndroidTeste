package com.example.testejava;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.testejava.adapter.Adapter;
import com.example.testejava.model.Product;
import com.example.testejava.service.HTTPService;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Product> listProduct = listAllProducts();
        final ListView productListView = (ListView) findViewById(R.id.quantity_card_products);
        final Adapter adapter = new Adapter(listProduct, this);
        productListView.setAdapter(adapter);

        final TextView totalPrice = (TextView) findViewById(R.id.total_price);
        final TextView subtotalPrice = (TextView) findViewById(R.id.subtotal_price);
        TextView stock = (TextView)findViewById(R.id.stock);
        final TextView shipping = (TextView)findViewById(R.id.shipping_price);
        final TextView tax = (TextView)findViewById(R.id.taxa_price);

        stock.setText(listProduct.size()+" Items in your card");

        productListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Product product = listProduct.get(position);
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("product",product);
                startActivity(intent);
                NumberFormat nf =NumberFormat.getCurrencyInstance();
                subtotalPrice.setText(String.valueOf(nf.format(product.getPrice())));
                shipping.setText(String.valueOf(nf.format(product.getShipping())));
                tax.setText(String.valueOf(nf.format(product.getTax())));
                totalPrice.setText(String.valueOf(nf.format(product.getPrice()+product.getTax()+product.getShipping())));
            }
        });
    }

    private List<Product> listAllProducts() {
        HTTPService service = new HTTPService();
        List<Product> aux = new ArrayList();
        try {
            aux = service.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return aux;
    }
}