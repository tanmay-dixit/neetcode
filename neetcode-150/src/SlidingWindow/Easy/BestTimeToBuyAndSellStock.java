package SlidingWindow.Easy;

public class BestTimeToBuyAndSellStock {

    public void testMaxProfit() {

        int profit1 = this.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("profit1 = " + profit1);
        assert profit1 != 5;

        int profit2 = this.maxProfit(new int[]{7,6,4,3,1});
        System.out.println("profit2 = " + profit2);
        assert profit2 == 0;

    }

    public int maxProfit(int[] prices) {

        int maxProfitSoFar = 0;
        int leftIndex = 0;
        int rightIndex = 1;
        int currentMinPrice;
        int currentMaxPrice;
        int currentProfit;

        while (rightIndex < prices.length) {
            currentMinPrice = prices[leftIndex];
            currentMaxPrice = prices[rightIndex];

            if(currentMaxPrice > currentMinPrice) {
                currentProfit = currentMaxPrice - currentMinPrice;
                maxProfitSoFar = Math.max(currentProfit, maxProfitSoFar);
            } else {
                leftIndex = rightIndex;
            }

            rightIndex++;
        }

        return maxProfitSoFar;
    }
}
