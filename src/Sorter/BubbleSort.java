package Sorter;

public class BubbleSort {
    /**
     * A simple implementation of bubble sort.
     * Simple check on swapped count of elements during each
     * iteration of outer loop, hence allowing the algorithm
     * to terminate early for better efficiency
     *
     * @param arr  Array to be sorted
     * @param <T>  Type of array element, implements Comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int swapCount = 0;
            for (int j = 0; j < len -1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swapCount++;
                    Swapper.swapArrayElement(arr, j, j + 1);
                }
            }
            if (swapCount == 0) return;
        }
    }
}
