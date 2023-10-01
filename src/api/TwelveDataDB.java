package api;

import entity.Stock;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TwelveDataDB implements StockDB{
    private static final String API_URL = "https://api.twelvedata.com/price?";

    private static final String API_TOKEN = System.getenv("apikey");

    public static String getApiToken() {
        return API_TOKEN;
    }

    @Override
    public Stock getPrice(String symbol) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.twelvedata.com/price?symbol=%s&apikey=%s", symbol, API_TOKEN))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt("status_code") == 200) {
                JSONObject stock = responseBody.getJSONObject("price");
                return Stock.builder()
                        .symbol(stock.getString("symbol"))
                        .price(stock.getFloat("price"))
                        .build();
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
