package Sorter;

import Helper.Swapper;

public class InsertionSort {
    /**
     * A helper method which inserts the element at index i of the given array
     * to its correct position within the sorted prefix
     *
     * @param arr  Array to be sorted
     * @param i    Index of the element to be inserted
     * @param <T>  Type of element, which implements Comparable interface
     */
    private static <T extends Comparable<T>> void insert(T[] arr, int i) {
        for (int x = i; x > 0; x--) {
            if (arr[x].compareTo(arr[x - 1]) >= 0) break;
            Swapper.swapArrayElement(arr, x, x - 1);
        }
    }

    /**
     * A simple implementation of insertion sort
     *
     * @param arr  Array to be sorted
     * @param <T>  Type of element in the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; i++) {
            insert(arr, i);
        }
    }
}
