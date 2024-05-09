package Sorter;

public class QuickSort {
    /**
     * A simple implementation of partition helper method for quick sort,
     * which takes the first element within the array by default as the pivot
     *
     * @param arr  Array to be partitioned
     * @param i    Starting index of the array proportion to be partitioned
     * @param j    Ending index to of the array proportion be partitioned(not included)
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
     * @param high  Ending index of arr(not included)
     * @param <T>   Type of element in the array, which implements the Comparable interface
     */
    private static <T extends Comparable<T>> void sortHelper(T[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIndex = partition(arr, low, high);
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
     * Three-way partitioning algorithm which improves the performance of quick sort
     * when sorting arrays filled with duplicating elements.
     *
     * @param arr  Array to be partitioned
     * @param i    Starting index of the proportion to be partitioned
     * @param j    Ending index of the proportion to be partitioned(not included)
     * @param p    Choice of pivot, which is the index of element within the array
     * @return     An int array, first element is left pivot index, second element is right pivot index
     * @param <T>  Type of element within the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> int[] threeWayPartition(T[] arr, int i, int j, int p) {
        T pivot = arr[p];
        Swapper.swapArrayElement(arr, p, i);

        int lessPointer = i;
        for (int x = i + 1; x < j; x++) {
            if (arr[x].compareTo(pivot) < 0) {
                lessPointer++;
                Swapper.swapArrayElement(arr, x, lessPointer);
            }
        }

        int equalPointer = lessPointer;
        for (int x = lessPointer + 1; x < j; x++) {
            if (arr[x].compareTo(pivot) == 0) {
                equalPointer++;
                Swapper.swapArrayElement(arr, x, equalPointer);
            }
        }

        int morePointer = j;
        for (int x = j - 1; x > equalPointer; x--) {
            if (arr[x].compareTo(pivot) > 0) {
                morePointer--;
                Swapper.swapArrayElement(arr, morePointer, x);
            }
        }

        //Note: Due to swapping of pivot stored at i and last element that is less than pivot
        //The lessPointer is now pointing at the first element within the == pivot region
        Swapper.swapArrayElement(arr, i, lessPointer);
        return new int[]{lessPointer, morePointer};
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
        int[] pivots = threeWayPartition(arr, low, high, p);
        int leftPivot = pivots[0];
        int rightPivot = pivots[1];
        improvedSortHelper(arr, low, leftPivot);
        improvedSortHelper(arr, rightPivot, high);
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