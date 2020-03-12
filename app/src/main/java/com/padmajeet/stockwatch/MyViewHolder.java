package com.padmajeet.stockwatch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



 /**
   * Author :  Padmajeet Pawar (A20451811)
   * Course :  Mobile Application Developement (CS442)
   * Date   :  03/09/2020
   * Version:  1.0v
   */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView symbol;
    public TextView price;
    public TextView change;
    public ImageView arrow;

    public MyViewHolder(View view){
        super(view);
        name = view.findViewById(R.id.nameID);
        symbol = view.findViewById(R.id.symbolID);
        price = view.findViewById(R.id.priceID);
        change = view.findViewById(R.id.changeID);
        arrow = itemView.findViewById(R.id.arrowImageView);
    }

}
