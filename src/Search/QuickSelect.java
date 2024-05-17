package Search;

import Helper.Partitioner;

public class QuickSelect {
    /**
     * Helper method for quick select algorithm using three-way partitioning and randomized pivot
     *
     * @param arr   Array to select element from
     * @param low   Starting index of the arr region
     * @param high  Ending index of the arr region
     * @param k     the k-th smallest element to be looked up during the search
     * @return      the k-th smallest element in the current region of the arr
     * @param <T>   Type of element in the array, which implements the Comparable interface
     */
    private static <T extends Comparable<T>> T selectHelper(T[] arr, int low, int high, int k) {
        //Base Case, checking if log, high and k are valid
        if (low > high || low < 0 || high >= arr.length) return null;
        if (k <= 0 || k > high - low + 1) return null;

        //Perform threeWay Partition on randomized pivot, keep track of left and right pivot index
        //and their respective position in overall sorted array
        int p = (int) (low + Math.random() * (high - low));
        int[] pivotIndex = Partitioner.threeWayPartition(arr, low, high + 1, p);
        int lowerPivotPosition = pivotIndex[0] + 1 - low;
        int higherPivotPosition = pivotIndex[1] + 1 - low;

        //Recurse to the correct side accordingly
        //If k is bigger than right Pivot Position, recurse to the right and find the
        //(k - higherPivotPosition)-th element
        if (higherPivotPosition < k) {
            return selectHelper(arr, pivotIndex[1] + 1, high, k - higherPivotPosition);
        //If left Pivot Position higher than k, recurse to left and find k-th element
        } else if (lowerPivotPosition > k) {
            return selectHelper(arr, low, pivotIndex[0] - 1, k);
        //Else, k lies within the left and right pivot region, return any pivot as answer
        } else {
            return arr[pivotIndex[0]];
        }
    }

    /**
     * Quick Select algorithm optimized with three-way partitioning and random pivot selection,
     * which allows for faster practical search time when dealing with array with duplicating elements.
     *
     * @param arr  Array to be selected from
     * @param k    the k-th smallest element to be looked up from the arr
     * @return     the k-th smallest element in the whole arr
     * @param <T>  Type of element in the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> T select(T[] arr, int k) {
        if (arr == null || arr.length == 0) return null;
        return selectHelper(arr, 0, arr.length - 1, k);
    }
}
