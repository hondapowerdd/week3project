package app;

import use_case.getPriceUseCase;

public class TEST {
    public static void main(String[] args) {
        Config config = new Config();

        getPriceUseCase getPriceUseCase = config.getPriceUseCase();

        String symbol = "AAPL";
        System.out.println("Price of " + symbol + " is " + getPriceUseCase.getPrice(symbol));
    }
}
