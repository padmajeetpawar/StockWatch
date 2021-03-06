package com.padmajeet.stockwatch;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

 /**
   * Author :  Padmajeet Pawar (A20451811)
   * Course :  Mobile Application Developement (CS442)
   * Date   :  03/09/2020
   * Version:  1.0v
   */

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    public static final String TAG = "RecViewAdapt";
    private List<Stock> stocksList;
    private MainActivity mainAct;

    public RecyclerViewAdapter(List<Stock> stckList, MainActivity ma){
        this.stocksList = stckList;
        mainAct = ma;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        Log.d(TAG, "onCreateViewHolder: MAKING NEW");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_list_row, parent, false);

        itemView.setOnClickListener(mainAct);
        itemView.setOnLongClickListener(mainAct);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Stock stock = stocksList.get(position);
        holder.name.setText(stock.getName());
        holder.symbol.setText(stock.getSymbol());
        holder.price.setText(String.format("%s",stock.getPrice()));
        holder.change.setText(String.format("%.2f (%.2f%%)", stock.getChange(), stock.getPercent()));
        if(stock.getChange() > 0){
            // for setting green
            holder.name.setTextColor(Color.GREEN);
            holder.symbol.setTextColor(Color.GREEN);
            holder.price.setTextColor(Color.GREEN);
            holder.change.setTextColor(Color.GREEN);
            holder.arrow.setImageResource(R.drawable.ic_arrow_up);
            holder.arrow.setColorFilter(Color.GREEN);

        }
        else{
            // for setting Red (< 1)
            holder.name.setTextColor(Color.RED);
            holder.symbol.setTextColor(Color.RED);
            holder.price.setTextColor(Color.RED);
            holder.change.setTextColor(Color.RED);
            holder.arrow.setImageResource(R.drawable.ic_arrow_down);
            holder.arrow.setColorFilter(Color.RED);
        }
    }

    @Override
    public int getItemCount(){ return stocksList.size();}


}
