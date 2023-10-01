package api;

import entity.Stock;
public interface StockDB {
    Stock getPrice(String symbol);
}
