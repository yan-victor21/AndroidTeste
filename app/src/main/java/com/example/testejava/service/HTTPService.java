package com.example.testejava.service;

import android.os.AsyncTask;

import com.example.testejava.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void,Void, List<Product>> {

    private String URLBase = "https://raw.githubusercontent.com/myfreecomm/desafio-mobile-android/master/api";

    @Override
    protected List<Product> doInBackground(Void... voids) {
        StringBuilder answer = new StringBuilder();
        try {
            URL url = new URL(URLBase+"/data.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setConnectTimeout(10000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()){
                answer.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Type itemListType = new TypeToken<ArrayList<Product>>(){}.getType();

        return new Gson().fromJson(String.valueOf(answer),itemListType);
    }
}
