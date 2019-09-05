package Google;

public class MergeSort {
    public int[] sortArray(int[] arr){
        if(arr.length <= 1) return arr;

        return mergeSort(arr, 0, arr.length-1);

    }

    public int[] mergeSort(int[] arr, int left, int right){
        if(right - left == 0) {
            return new int[]{arr[left]};
        }
        int midIndex = (right+left)/2;
        int[] leftArray = mergeSort(arr, left, midIndex);
        int[] rightArray = mergeSort(arr, midIndex+1, right);
        return merge(leftArray, rightArray);
    }

    public int[] merge(int[] leftArray, int[] rightArray){
        int[] retArray = new int[leftArray.length + rightArray.length];
        int lPointer =0, rPointer = 0;
        for (int i = 0 ; i< retArray.length; i++){
            if(rPointer>rightArray.length-1 || (lPointer < leftArray.length && leftArray[lPointer] < rightArray[rPointer])){
                retArray[i] = leftArray[lPointer];
                lPointer++;
            }else{
                retArray[i] = rightArray[rPointer];
                rPointer++;
            }
        }
//        for(int i=0; i<retArray.length; i++){
//            System.out.print(retArray[i] + "  ");
//        }
//        System.out.println();
        return retArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-90, 86, 25, -56, 91, -13, 92, -69, 98, 95, 29};
//        int[] arr = new int[]{0,-1,0,-1};
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.sortArray(arr);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + "  ");
        }
    }
}
