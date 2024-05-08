package Sorter;

public class QuickSort {
    /**
     * A simple implementation of partition helper method for quick sort,
     * which takes the first element within the array by default as the pivot
     *
     * @param arr  Array to be partitioned
     * @param i    Starting index to be partitioned
     * @param j    Ending index to be partitioned
     * @return     Index of the pivot after partition finish
     * @param <T>  Type of element within the array, which implements the Comparable interface
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int i, int j) {
        T pivot = arr[i];
        int low = i;
        int high = j;
        while(low < high) {
            while (low < high && arr[low].compareTo(pivot) <= 0) low++;
            while (low < high && (high == arr.length || arr[high].compareTo(pivot) > 0)) high--;
            if (low < high) {
                Swapper.swapArrayElement(arr, low, high);
            }
        }
        Swapper.swapArrayElement(arr, i, low - 1);
        return low - 1;
    }

    /**
     * Helper method for simple quick sort.
     *
     * @param arr   Array to be sorted
     * @param low   Starting index of arr
     * @param high  Ending index of arr
     * @param <T>   Type of element in the array, which implements the Comparable interface
     */
    private static <T extends Comparable<T>> void sortHelper(T[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIndex = partition(arr, low, high);
        sortHelper(arr, low, pivotIndex);
        sortHelper(arr, pivotIndex + 1, high);
    }

    /**
     * A simple implementation of quick sort
     *
     * @param arr  The array to be sorted
     * @param <T>  The type of element within the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        sortHelper(arr, 0, arr.length);
    }
}
