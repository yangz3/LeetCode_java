public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;  //just remember the smallest price
        int[] states = new int [prices.length + 1]; // states[i] represents maximum profit made from day 0 to day i
        states[0] = 0;
        
        for (int i = 1; i<= prices.length; i++ ) {
            
            min = Math.min(prices[i - 1],min); // minimum buy in price up until day i
            
            int profit = prices[i - 1] - min; // define profit to be current price minus the lowest stock price seen before
            
            if(profit > states[i - 1]){
                states[i] = profit;
            }else{
                states[i] = states[i - 1];
            }
        }
        
        return states[prices.length];
    }
}