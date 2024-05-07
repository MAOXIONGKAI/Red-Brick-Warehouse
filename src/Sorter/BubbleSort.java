package Sorter;

public class BubbleSort {
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
