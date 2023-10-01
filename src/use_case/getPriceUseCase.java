package use_case;

import api.StockDB;
import entity.Stock;

public class getPriceUseCase {
    private final StockDB stockDB;

    public getPriceUseCase(StockDB stockDB) {
        this.stockDB = stockDB;
    }

    public Stock getPrice(String symbol) {
        return stockDB.getPrice(symbol);
    }
}
