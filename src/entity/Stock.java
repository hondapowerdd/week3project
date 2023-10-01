package entity;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    private String symbol;
    private Float price;

    public Stock(String symbol, Float price){
        this.symbol = symbol;
        this.price = price;
    }

    public float getPrice(){
        return this.price;
    }
}
