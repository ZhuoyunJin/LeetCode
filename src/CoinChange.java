
public class CoinChange {
	/**
	 * You are given coins of different denominations and a total amount of money amount. 
	 * Write a function to compute the fewest number of coins that you need to make up that amount. 
	 * If that amount of money cannot be made up by any combination of the coins, return -1.
	 * You may assume that you have an infinite number of each kind of coin.
	 */
	public int coinChange(int[] coins, int amount) {
		if(amount<1) return 0;
		int[] arr = new int[amount+1];
		for(int i=0;i<arr.length;i++){
			arr[i]= Integer.MAX_VALUE;
		}
		for(int i=0;i<coins.length;i++){
			if(coins[i]<=amount)
				arr[coins[i]] = 1;
		}
		for(int i=1;i<=amount;i++){
			for(int j: coins){
				if(i==j) continue;
				if(i-j>0){
					if(arr[i-j] < Integer.MAX_VALUE && arr[i-j] +1 <arr[i]){
						arr[i] = arr[i-j] +1;
					}
				}
			}
		}
		return arr[amount] ==Integer.MAX_VALUE? -1: arr[amount];
	}
	public static void main(String[] args) {
		CoinChange coinChange = new CoinChange();
		System.out.println(coinChange.coinChange(new int[]{2}, 1));
	}
}
