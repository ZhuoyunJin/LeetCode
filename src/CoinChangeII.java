
public class CoinChangeII {
	/**
	 * You are given coins of different denominations and a total amount of money. 
	 * Write a function to compute the number of combinations that make up that amount. 
	 * You may assume that you have infinite number of each kind of coin.
	 */
	public int change(int amount, int[] coins) {
		//if(amount<1) return 0;
		int[] arr = new int[amount+1];
		arr[0] = 1;
		for(int denomination: coins){
			for(int i=denomination;i<=amount;i++){
				arr[i]+=arr[i-denomination];
			}
		}

		return arr[amount];
	}
	public static void main(String[] args) {
		CoinChangeII coinChange = new CoinChangeII();
		System.out.println(coinChange.change(0, new int[]{1, 2}));
	}

}
