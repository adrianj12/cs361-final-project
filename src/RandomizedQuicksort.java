import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the QuickSort algorithm with a randomized pivot selection.
 * It provides an efficient sorting mechanism for arrays of integers.
 *
 * @author Adam Abusang
 */
class RandomizedQuickSort {

    /**
     * Swaps two elements in an array.
     *
     * @param array The array where the swap will occur.
     * @param i The index of the first element to be swapped.
     * @param j The index of the second element to be swapped.
     */
    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private static void swap(double[] array, int i, int j) {
        if (i != j) {
            double temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Partitions the array around a pivot. All elements less than the pivot are moved to its left,
     * and all greater elements are moved to its right. The pivot is chosen randomly.
     *
     * @param array The array to be partitioned.
     * @param low The starting index for the partitioning.
     * @param high The ending index for the partitioning.
     * @return The index of the pivot after partitioning.
     */
    private static int partition(int[] array, int low, int high) {
        // Randomization of the pivot to improve performance on sorted data.
        int pivotIndex = low + (int) (Math.random() * (high - low));
        swap(array, pivotIndex, high);

        int pivot = array[high];
        int i = (low - 1); // Tracks the position for swapping.

        for (int j = low; j < high; j++) {
            // Move elements smaller than pivot to the left.
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        // Place the pivot in its correct position.
        swap(array, i + 1, high);
        return i + 1;
    }

    private static int partition(double[] array, int low, int high) {
        // Randomization of the pivot to improve performance on sorted data.
        int pivotIndex = low + (int) (Math.random() * (high - low));
        swap(array, pivotIndex, high);
        double pivot = array[high];
        int i = (low - 1); // Tracks the position for swapping.
        for (int j = low; j < high; j++) {
            // Move elements smaller than pivot to the left.
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        // Place the pivot in its correct position.
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Implements the QuickSort algorithm using an iterative approach with a stack.
     * It sorts a portion of the array between startIndex and endIndex.
     *
     * @param array The array to be sorted.
     * @param startIndex The starting index for sorting.
     * @param endIndex The ending index for sorting.
     */
    static void quickSort(int[] array, int startIndex, int endIndex) {
        List<Integer> stack = new ArrayList<>();

        // Initialize the stack with the initial range to be sorted.
        stack.add(startIndex);
        stack.add(endIndex);

        // Continuously sort the array until the stack is empty.
        while (!stack.isEmpty()) {
            endIndex = stack.remove(stack.size() - 1);
            startIndex = stack.remove(stack.size() - 1);

            int partitionIndex = partition(array, startIndex, endIndex);

            // If there are elements on the left side of the pivot, add them to the stack.
            if (partitionIndex - 1 > startIndex) {
                stack.add(startIndex);
                stack.add(partitionIndex - 1);
            }
            // If there are elements on the right side of the pivot, add them to the stack.
            if (partitionIndex + 1 < endIndex) {
                stack.add(partitionIndex + 1);
                stack.add(endIndex);
            }
        }
    }

    static void quickSort(double[] array, int startIndex, int endIndex) {
        List<Integer> stack = new ArrayList<>();
        // Initialize the stack with the initial range to be sorted.
        stack.add(startIndex);
        stack.add(endIndex);
        // Continuously sort the array until the stack is empty.
        while (!stack.isEmpty()) {
            endIndex = stack.remove(stack.size() - 1);
            startIndex = stack.remove(stack.size() - 1);
            int partitionIndex = partition(array, startIndex, endIndex);
            // If there are elements on the left side of the pivot, add them to the stack.
            if (partitionIndex - 1 > startIndex) {
                stack.add(startIndex);
                stack.add(partitionIndex - 1);
            }
            // If there are elements on the right side of the pivot, add them to the stack.
            if (partitionIndex + 1 < endIndex) {
                stack.add(partitionIndex + 1);
                stack.add(endIndex);
            }

        }

    }

}
