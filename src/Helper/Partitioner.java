package Helper;

public class Partitioner {
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
    public static <T extends Comparable<T>> int partition(T[] arr, int i, int j) {
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
        return new int[]{lessPointer, morePointer - 1};
    }
}
