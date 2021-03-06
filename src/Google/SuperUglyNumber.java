package Google;

import java.util.Arrays;

/**
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k <= 100, 0 < n <= 106, 0 < primes[i] < 1000.
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumberI(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0]=1;
		int[] L=new int[primes.length];
		int i=2;
		while(i<=n){
			int min=Integer.MAX_VALUE;
			int index=0;
			for(int j=0;j<L.length;j++){
				if(primes[j]*ugly[L[j]]<min){
					min=primes[j]*ugly[L[j]];
					index=j;
				}
			}
			L[index]++;
			if(ugly[i-2]!=min){
				ugly[i-1]=min;
				i++;
			}
		}
		return ugly[n-1];
	}

	public int nthSuperUglyNumberII(int n, int[] primes) {
		int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
	}
}
