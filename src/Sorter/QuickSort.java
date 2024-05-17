package Sorter;

import Helper.Partitioner;

public class QuickSort {


    /**
     * Helper method for simple quick sort.
     *
     * @param arr   Array to be sorted
     * @param low   Starting index of arr
     * @param high  Ending index of arr(not included)
     * @param <T>   Type of element in the array, which implements the Comparable interface
     */
    private static <T extends Comparable<T>> void sortHelper(T[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIndex = Partitioner.partition(arr, low, high);
        sortHelper(arr, low, pivotIndex);
        sortHelper(arr, pivotIndex + 1, high);
    }

    /**
     * A simple implementation of quick sort.
     * With O(nlogn) time for general sorting, and O(n^2) worst case sorting time
     *
     * @param arr  The array to be sorted
     * @param <T>  The type of element within the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        sortHelper(arr, 0, arr.length);
    }

    /**
     * Helper method for improved quick sort, using three-way partitioning helper method
     *
     * @param arr   Array to be sorted
     * @param low   Starting index of the proportion to be sorted
     * @param high  Ending index of the proportion to be sorted(not included)
     * @param <T>   Type of element within the array, which implements Comparable interface
     */
    private static <T extends Comparable<T>> void improvedSortHelper(T[] arr, int low, int high) {
        if (low >= high) return;
        int p = low + (int) (Math.random() * (high - low));
        int[] pivots = Partitioner.threeWayPartition(arr, low, high, p);
        int leftPivot = pivots[0];
        int rightPivot = pivots[1];
        improvedSortHelper(arr, low, leftPivot);
        improvedSortHelper(arr, rightPivot + 1, high);
    }

    /**
     * Improved Quick Sort using three-way partitioning and random pivot choice.
     * O(n) time for sorting duplicating array, and expected O(nlogn) time for general sorting
     *
     * @param arr  Array to be sorted
     * @param <T>  Type of element within the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> void improvedSort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        improvedSortHelper(arr, 0, arr.length);
    }
}