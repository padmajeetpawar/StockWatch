package com.padmajeet.stockwatch;

/*
   Author :  Padmajeet Pawar (A20451811)
   Course :  Mobile Application Developement (CS442)
   Date   :  03/09/2020
   Version:  1.0v
*/

public class Stock implements Comparable<Stock> {

    
    private String name;
    private String symbol;
    private double price;
    private double change;
    private double percent;

    public Stock(String name, String symbol, double price, double change, double percent) {
//        setName( name);
//        setSymbol( symbol );
//        setPrice( price );
//        setChange( change );
//        setPercent( percent );
        this.name = name;
        this.symbol= symbol;
        this.price = price;
        this.change = change;
        this.percent = percent;

    }

   /* public Stock(String name, String symbol) {
        setName( name);
        setSymbol( symbol );
    }*/

    public Stock(String name, String symbol) {
        this.name = name;
        this.symbol= symbol;
        this.price = 0.0;
        this.change = 0.0;
        this.percent = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", change=" + change +
                ", percent=" + percent +
                '}';
    }

    @Override
    public int compareTo(Stock that){
       

        return this.getSymbol().compareTo( that.getSymbol() );
    }
}
