package entity;

public class Stock {
    private String symbol;
    private Float price;

    public Stock(String symbol, Float price){
        this.symbol = symbol;
        this.price = price;
    }

    public static StockBuilder builder(){
        return new StockBuilder();
    }

    public static class StockBuilder{
        private String symbol;
        private Float price;

        StockBuilder(){
        }

        public StockBuilder symbol(String symbol){
            this.symbol = symbol;
            return this;
        }

        public StockBuilder price(Float price){
            this.price = price;
            return this;
        }

        public Stock build(){
            return new Stock(symbol, price);
        }
    }

    public float getPrice(){
        return this.price;
    }
}
