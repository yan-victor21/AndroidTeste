package com.example.testejava;

import android.content.Intent;
import android.os.Bundle;

import com.example.testejava.model.Product;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        //Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        NumberFormat nf =NumberFormat.getCurrencyInstance();
        Intent i = getIntent();
        Product prod =(Product) i.getSerializableExtra("product");

        ImageView imageProductDetail = (ImageView)findViewById(R.id.image_product_detail);
        TextView nameProductDetail = (TextView)findViewById(R.id.name_product_detail);
        TextView stockProductDetail =(TextView)findViewById(R.id.stock_product_detail);
        TextView priceProductDetail =(TextView)findViewById(R.id.price_product_detail);
        TextView descriptionDetail = (TextView)findViewById(R.id.description_detail);

        Spanned texto = Html.fromHtml("<small>"+prod.getDescription()+"</small><br/>");
        descriptionDetail.setText(texto);

        Picasso.get().load(prod.getImage_url()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageProductDetail,new com.squareup.picasso.Callback(){@Override public void onSuccess(){} @Override public void onError(Exception e) {}});

        nameProductDetail.setText(prod.getName());
        if(prod.getStock()>1){
            stockProductDetail.setText("in stock");
        }else if(prod.getStock() == 1){
            stockProductDetail.setText("only 1 left in stock");
        }
        priceProductDetail.setText(String.valueOf(nf.format(prod.getPrice())));
        descriptionDetail.setText(prod.getDescription());
    }
}