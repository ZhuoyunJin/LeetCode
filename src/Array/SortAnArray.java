package Array;

public class SortAnArray {
    public int[] sortArray(int[] arr){
        if(arr.length <= 1) return arr;

        quickSort(arr, 0, arr.length-1);

        return arr;
    }

    public void quickSort(int[] arr, int left, int right){
        if(right - left <= 0) return;
        int pivotIndex = left;
        int pivot = arr[left];
        int leftPointer = left + 1;
        int rightPointer = right;

        while(leftPointer < rightPointer){
            while(arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            while(arr[leftPointer] < pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            if(leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            }
        }

        if(arr[leftPointer] < pivot) {
            swap(arr, left, leftPointer);
            pivotIndex = leftPointer;
        }
        quickSort(arr, left, pivotIndex-1);
        quickSort(arr, pivotIndex + 1, right);
    }

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-90, 86, 25, -56, 91, -13, 92, -69, 98, 95, 29};
        int[] arr = new int[]{0,-1,0,-1};
        SortAnArray quickSort = new SortAnArray();
        quickSort.sortArray(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}
