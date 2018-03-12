package Utility;

public class ArrayHelper {
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

	public static void printArray(boolean[][] array) {
		for(int i=0; i<array[0].length;i++) {
			for(int j=0; j<array.length;j++) {
				if(j>0)
					System.out.print(", ");
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
