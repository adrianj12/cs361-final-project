/*
 * Adrian Abeyta <ajabeyta@unm.edu>
 * Final Project - Sorting Algorithms
 * CS 361 - Prof. Luan
 * 12.6.2023
 */

// @TODO comment methods

public class IntQuadHeap {

    /* Heap properties */
    private final int[] minHeap;
    private int size;

    public IntQuadHeap(int n) {

        this.size = 0;
        this.minHeap = new int[n];

    }

    public void insert(int key) {

        int i = size;

        minHeap[size] = key;
        size++;

        while(i != 0 && (minHeap[i] < minHeap[getParent(i)])) {

            swap(i, getParent(i));
            i = getParent(i);

        }

    }

    private void heapify(int index) {

        int min = index;
        int child;

        // iterate over children
        for(int i = 1; i <= 4; i++) {

            child = getChild(index, i);
            if(child < size && minHeap[child] < minHeap[min])
                min = child;

        }

        if(min != index) {

            swap(index, min);
            heapify(min);

        }

    }

    public int extractMin() {

        int root = minHeap[0];

        if(size < 1) {

            return 0;

        } else if(size == 1) {

            size--;
            return root;

        }

        minHeap[0] = minHeap[size - 1];
        size--;
        heapify(0);

        return root;

    }

    public void sort(int[] array) {

        for(int key : array) {
            insert(key);
        }

        for(int i = 0; i < array.length; i++) {

            array[i] = extractMin();

        }

    }

    private int getParent(int index) {
        return (index - 1) / 4;
    }

    private int getChild(int index, int k) {
        return (4 * index) + k;
    }

    private void swap(int i, int j) {

        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;

    }

}
