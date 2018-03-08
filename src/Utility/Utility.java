package Utility;

public class Utility {
	public static <T>void printArray(T[] array) {
		int i=0;
		for(T element : array) {
			if(i++>0)
				System.out.print(", ");
			System.out.print(element);
		}
		System.out.println();
	}
	
	public static void printArray(int[] array) {
		int i=0;
		for(int element : array) {
			if(i++>0)
				System.out.print(", ");
			System.out.print(element);
		}
		System.out.println();
	}
}
