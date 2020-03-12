package com.padmajeet.stockwatch;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

 /**
   * Author :  Padmajeet Pawar (A20451811)
   * Course :  Mobile Application Developement (CS442)
   * Date   :  03/09/2020
   * Version:  1.0v
   */

public class AsyncFinancialDataLoader extends AsyncTask<String,Integer,String> {

    private MainActivity mainActivity;
    private int count;

    private final String dataURLPrefix = "https://cloud.iexapis.com/stable/stock/";
    private final String getDataURLSuffix = "/quote?token=pk_906d294dcbee4166a38429e39645c0d9";
    private static final String TAG = "AsyncFinDataLoader";

    public AsyncFinancialDataLoader(MainActivity ma){ mainActivity = ma;}

    @Override
    protected void onPreExecute(){ }

    @Override
    protected void onPostExecute(String s) {
        Stock stock = parseJSON(s);
        mainActivity.addNewStock(stock);
        
    }

    @Override
    protected String doInBackground(String... params) {

        String dataURL = dataURLPrefix + params[0] + getDataURLSuffix;
        Log.d(TAG, "doInBackground: URL is " + dataURL);
        Uri dataUri = Uri.parse(dataURL);
        String urlToUse = dataUri.toString();
        Log.d(TAG, "doInBackground: " + urlToUse);

        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlToUse);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader((new InputStreamReader(is)));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            Log.d(TAG, "doInBackground: " + sb.toString());

        } catch (Exception e) {
            Log.e(TAG, "doInBackground: ", e);
            return null;
        }

        Log.d(TAG, "doInBackground: " + sb.toString());
        Log.d(TAG, "doInBackground: returning");
        return sb.toString();
    }

    private Stock parseJSON(String s) {

        Log.d(TAG, "parseJSON: started JSON");

        ArrayList<Stock> stocksList = new ArrayList<>();
        try {
            JSONObject jStock = new JSONObject(s); // {}
            String symbol = jStock.getString("symbol");
            double price = Double.parseDouble (jStock.getString("latestPrice"));
            double change = Double.parseDouble (jStock.getString("change"));
            double percent = Double.parseDouble (jStock.getString("changePercent"));
            Stock stock = new Stock("", symbol, price, change, percent);
            return stock;
        } catch (Exception e) {
            Log.d(TAG, "parseJSON: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
