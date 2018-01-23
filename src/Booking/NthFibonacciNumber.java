package Booking;

public class NthFibonacciNumber {
	public static int recursion(int n) {
		if(n<0) return 0;
		if(n==1 || n==2) return 1;
		return recursion(n-1)+recursion(n-2);
	}
	
	public static int iteration(int n) {
		if(n<0) return 0;
		if(n==1 || n==2) return 1;
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<n;i++){
			arr[i] = arr[i-1]+arr[i-2];
		}
		return arr[n-1];
	}
	public static void main(String[] args) {
		System.out.println(recursion(6));
		System.out.println(iteration(6));
	}

}
