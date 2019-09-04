package Google;

public class QuickSort {

    public void quickSort(int[] arr){
        if(arr.length <= 1) return;

        quickSort(arr, 0, arr.length-1);
    }

    public void quickSort(int[] arr, int left, int right){
        if(right - left <= 0) return;;

        int pivot = arr[left];
        int leftPointer = left + 1;
        int rightPointer = right;

        while(leftPointer < rightPointer){
            while(arr[rightPointer] > pivot){
                rightPointer--;
            }
            while(arr[leftPointer] < pivot ){
                leftPointer++;
            }
            swap(arr, leftPointer, rightPointer);
        }

        swap(arr, left, leftPointer);

        quickSort(arr, left, leftPointer-1);
        quickSort(arr, leftPointer + 1, right);
    }

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,4,3,7,6};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
