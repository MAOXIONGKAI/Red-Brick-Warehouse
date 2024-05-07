package Search;

public class PeakFinding {
    /**
     * A helper method which determine if element specified at the index
     * of the array is a peak.
     * A peak is defined as an element that is higher than or equal to its
     * neighbours.
     *
     * @param arr    Array to be searched
     * @param index  Index of the element
     * @return       Boolean value indicating if the element is a peak
     * @param <T>    Type of element which implements Comparable interface
     */
    private static <T extends Comparable<T>> boolean isPeakAt(T[] arr, int index) {
        boolean leftCompare = index == 0 || arr[index].compareTo(arr[index - 1]) >= 0;
        boolean rightCompare = index == arr.length - 1 || arr[index].compareTo(arr[index + 1]) >= 0;
        return leftCompare && rightCompare;
    }

    /**
     * 1D Peak Finding algorithm using divide & conquer approach
     * similar to binary search.
     *
     * @param arr  Array to be searched
     * @return     Any Local Maximum within the array
     * @param <T>  Type of element in the array, which implements Comparable interface
     */
    public static <T extends Comparable<T>> T search1D(T[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int mid = low + (high - low) / 2;
        if (isPeakAt(arr, mid)) {
            return arr[mid];
        }

        if (mid < arr.length - 1 && arr[mid].compareTo(arr[mid + 1]) < 0) {
            return search1D(arr, mid + 1, high);
        }

        if (mid > 0 && arr[mid].compareTo(arr[mid - 1]) < 0) {
            return search1D(arr, low, mid);
        }
        return null;
    }
}