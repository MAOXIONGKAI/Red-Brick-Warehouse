package Sorter;

public class MergeSort {
    /**
     * A simple implementation of merge helper method for merge sort.
     *
     * @param arr         Array in which the merge happens
     * @param leftStart   Starting index of first half of array segment
     * @param leftEnd     Ending index of the first half of array segment
     * @param rightStart  Starting index of second half of array segment
     * @param rightEnd    Ending index of the second half of array segment
     * @param <T>         Type of element in the array, which implements Comparable interface
     */
    private static <T extends Comparable<T>> void merge(T[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int resultIndex = 0;
        int len = rightEnd - leftStart + 1;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[len];

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
                temp[resultIndex] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[resultIndex] = arr[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex <= leftEnd) {
            temp[resultIndex] = arr[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex <= rightEnd) {
            temp[resultIndex] = arr[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        for (int i = 0; i < len; i++) {
            arr[leftStart + i] = temp[i];
        }
    }

    /**
     * Helper method for simple merge sort.
     *
     * @param arr   Array to be sorted
     * @param low   Starting index of the array segment
     * @param high  Ending index of the array segment
     * @param <T>   Type of element in the array, which implements Comparable interface
     */
    private static <T extends Comparable<T>> void sortHelper(T[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sortHelper(arr, low, mid);
        sortHelper(arr, mid + 1, high);
        merge(arr, low, mid, mid + 1, high);
    }

    /**
     * A simple implementation of merge sort, with O(nlogn) extra space
     *
     * @param arr  Array to be sorted
     * @param <T>  Type of element in the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        sortHelper(arr, 0, arr.length - 1);
    }

    /**
     * Improved implementation of merge helper method for improved merge sort
     *
     * @param arr         Array whose parts has to be merged
     * @param temp        Array which stores the result of merging
     * @param leftStart   Starting index of the first part of the arr
     * @param leftEnd     Ending index of the first part of arr
     * @param rightStart  Starting index of the second part of the arr
     * @param rightEnd    Ending index of the second part of the arr
     * @param <T>         Type of element within the array, which implements the Comparable interface
     */
    private static <T extends Comparable<T>> void improvedMerge(T[] arr, T[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int resultIndex = leftStart;
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
                temp[resultIndex] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[resultIndex] = arr[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex <= leftEnd) {
            temp[resultIndex] = arr[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex <= rightEnd) {
            temp[resultIndex] = arr[rightIndex];
            rightIndex++;
            resultIndex++;
        }
    }

    /**
     * Helper method for improved merge sort.
     *
     * @param arr   Array to be sorted
     * @param temp  Array to be split and sorted and merge together
     * @param low   Starting index of arr
     * @param high  Ending index of arr
     * @param <T>   Type of elements within the array, which implements Comparable interface
     */
    private static <T extends Comparable<T>> void improvedSortHelper(T[] arr, T[] temp, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        improvedSortHelper(temp, arr, low, mid);
        improvedSortHelper(temp, arr, mid + 1, high);
        improvedMerge(temp, arr, low, mid, mid + 1, high);
    }

    /**
     * Improved version of merge sort, which has O(n) extra space only
     *
     * @param arr  Array to be sorted
     * @param <T>  Type of elements within the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> void improvedSort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        improvedSortHelper(arr, temp, 0, arr.length - 1);
    }
}
