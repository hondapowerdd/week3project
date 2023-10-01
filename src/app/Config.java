package app;

import api.StockDB;
import api.TwelveDataDB;
import use_case.*;

public class Config {
    private final StockDB stockDB = new TwelveDataDB();

    public getPriceUseCase getPriceUseCase() {
        return new getPriceUseCase(stockDB);
    }
}
