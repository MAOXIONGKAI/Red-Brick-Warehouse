package Search;

public class BinarySearch {
    /**
     * A simple binary search
     *
     * @param arr  An array whose element is of type that implements Comparable Interface
     * @param key  The key to be searched within the array
     * @return     The index of any matching element within the array
     * @param <T>  A type that implements Comparable Interface
     */
    public static <T extends Comparable<T>> int search(T[] arr, T key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(arr[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low] == key
                ? low
                : -1;
    }

    /**
     * A special variant of binary search, covered in 2023/24 sem2 CS2040S Final Paper
     * Instead of returning any index whose element matches the key, this search method
     * returns the largest index that satisfy the search.
     *
     * @param arr  An array whose element is of type that implements Comparable Interface
     * @param key  The key to be searched within the array
     * @return     The largest index of any matching element within the array
     * @param <T>  A type that implements Comparable Interface
     */
    public static <T extends Comparable<T>> int searchMax(T[] arr, T key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (key.compareTo(arr[mid]) >= 0) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return arr[low] == key
                ? low
                : -1;
    }
}