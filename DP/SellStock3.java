public class Solution {
    public int maxProfit(int[] price) {
        if(price == null || price.length == 0){
            return 0;
        }
        
        int[] statesToRight = new int[price.length + 1];
        int[] statesToLeft = new int[price.length + 1];
        
        statesToRight[0] = 0;
        statesToLeft[price.length] = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i <=  price.length; i++){
            if(price[i-1] < min){
                min = price[i-1];
            }
            int profit = price[i-1] - min;
            if(profit > statesToRight[i-1]){
                statesToRight[i] = profit;
            }else{
                statesToRight[i] = statesToRight[i-1];
            }
        }
        
        for(int i = price.length - 1; i >=  0; i--){
            if(price[i] > max){
                max = price[i];
            }
            int profit = max - price[i];
            if(profit > statesToLeft[i+1]){
                statesToLeft[i] = profit;
            }else{
                statesToLeft[i] = statesToLeft[i+1];
            }
        }
        
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < price.length; i++){
            if(statesToRight[i+1] + statesToLeft[i] > maxProfit){
                maxProfit = statesToRight[i+1] + statesToLeft[i];
            }
        }
        
        return maxProfit;
    }
    
}