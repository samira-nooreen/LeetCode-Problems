class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int max_Profit = 0;
        int buy_price=prices[0];

        for(int i =0 ; i<n ; i++){
            int curr_price = prices[i] - buy_price;

            if(curr_price > max_Profit){
                max_Profit = curr_price;
            }
            if(prices[i] < buy_price){
                buy_price = prices[i];
            }
        }
        return max_Profit;

    }
}
