public class P121BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int[] maxProfitSoFar = new int[prices.length];
        int minSoFar = prices[0];

        maxProfitSoFar[0] = 0;

        for(int i = 1; i<prices.length; i++) {
            if(prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            var diff = prices[i] - minSoFar;
            if(diff > 0) {
                if( diff > maxProfitSoFar[i-1]) {
                    maxProfitSoFar[i] = diff;
                } else {
                    maxProfitSoFar[i] = maxProfitSoFar[i-1];
                }
            } else {
                maxProfitSoFar[i] = maxProfitSoFar[i-1];
            }
        }
        return maxProfitSoFar[prices.length-1];
    }
}
