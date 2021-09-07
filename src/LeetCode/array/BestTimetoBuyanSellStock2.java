package LeetCode.array;

public class BestTimetoBuyanSellStock2 {
    public static void main(String[] args) {
        BestTimetoBuyanSellStock2 b = new BestTimetoBuyanSellStock2();
        int[] price = {2,1,2,0,1};
        System.out.println(b.maxProfit(price));
    }
    public int maxProfit(int[] prices) {
        int buy = -1;
        int sell = -1;
        int maximum = 0;
        for(int i = 0; i < prices.length; i++){
            if(buy == -1){
                buy = prices[i];
            }else if(buy > prices[i] && sell == -1){
                buy = prices[i];
            }else if(sell == 0){
                sell = prices[i];
            }else if(sell > prices[i]){
                maximum += sell - buy;
                buy = prices[i];
                sell = -1;
            }else{
                sell = prices[i];
            }
        }

        if(sell - buy > 0){
            maximum += sell - buy;
        }
        return maximum;

    }
}
