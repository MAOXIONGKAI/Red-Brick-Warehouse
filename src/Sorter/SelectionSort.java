package Sorter;

public class SelectionSort {
    /**
     * A simple implementation of selection sort
     *
     * @param arr  Array to be sorted
     * @param <T>  Type of element in the array, implements Comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            boolean sorted = true;
            T min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                    sorted = false;
                }
                if (arr[j].compareTo(min) < 0) {
                    min = arr[j];
                    index = j;
                }
            }
            if (sorted) break;
            Swapper.swapArrayElement(arr, index, i);
        }
    }
}
