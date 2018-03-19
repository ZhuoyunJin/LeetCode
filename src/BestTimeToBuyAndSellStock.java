
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null) return 0;
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++) {
			int current = prices[i];
			minPrice = Math.min(minPrice, current);
			profit = Math.max(profit, current-minPrice);
		}
		return profit>0?profit:0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
