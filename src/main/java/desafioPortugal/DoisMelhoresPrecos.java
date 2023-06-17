package desafioPortugal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class DoisMelhoresPrecos {
    private static final int MAX_ELEMENTS = 2;

    public static void main(String[] args) {
        String[] stocks = {"AMZN", "CACC", "EQIX", "GOOG", "ORLY", "ULTA"};
        float[][] prices = {{15.0f, 72.0f, 300.0f, 40.0f, 85.0f, 26.0f},
                {7.0f, 28.0f, 9.0f, 130.0f, 115.0f, 12.0f},
                {23.0f, 4.0f, 150.0f, 16.0f, 177.0f, 189.0f}};

        List<BigDecimal> averagePrices = retrunAveragePrice(prices);
        Map<String, BigDecimal> priceSheet = returnMapPrices(stocks, averagePrices);
        showTwoBestPrices(priceSheet);
    }

    private static void showTwoBestPrices(Map<String, BigDecimal> priceSheet) {
        int showElements = 0;
        for (var entry : priceSheet.entrySet()) {
            if(showElements >= MAX_ELEMENTS) break;
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
            showElements++;
        }
    }

    private static Map<String, BigDecimal> returnMapPrices(String[] stocks, List<BigDecimal> averagePrices) {
        Map<String, BigDecimal> priceSheet = new TreeMap<>();
        for (int i = 0; i < stocks.length; i++)
            priceSheet.put(stocks[i], averagePrices.get(i));
        return priceSheet;
    }

    private static List<BigDecimal> retrunAveragePrice(float[][] prices) {
        List<BigDecimal> pricesStocks = new ArrayList<>();
        int lineSize = prices[0].length;
        for(int j = 0; j < lineSize; j++)
            pricesStocks.add(returnAveragePrice(j, prices));
        Collections.sort(pricesStocks);
        return pricesStocks;
    }

    private static BigDecimal returnAveragePrice(int matrixRow, float[][] prices) {
        float sum=0f;
        for (float[] price : prices) sum += price[matrixRow];
        return new BigDecimal(sum / prices.length).setScale(2, RoundingMode.HALF_UP);
    }
}