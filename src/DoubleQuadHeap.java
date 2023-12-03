/*
 * Adrian Abeyta <ajabeyta@unm.edu>
 * Final Project - Sorting Algorithms
 * CS 361 - Prof. Luan
 * 12.6.2023
 */

public class DoubleQuadHeap {

    /* Heap properties */
    private final double[] minHeap;
    private int size;

    public DoubleQuadHeap(int n) {

        this.size = 0;
        this.minHeap = new double[n];

    }

    public void insert(double key) {

        int i = size;

        minHeap[size] = key;
        size++;

        while(i != 0 && (minHeap[i] < minHeap[parent(i)])) {

            swap(i, parent(i));
            i = parent(i);

        }

    }

    private void heapify(int index) {

        int min = index;
        int child;

        for(int i = 1; i <= 4; i++) {

            child = child(index, i);
            if(child < size && minHeap[child] < minHeap[min])
                min = child;

        }

        if(min != index) {

            swap(index, min);
            heapify(min);

        }

    }

    public double extractMin() {

        double root = minHeap[0];

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

    public void sort(double[] array) {

        for(double key : array) {
            insert(key);
        }

        for(int i = 0; i < array.length; i++) {

            array[i] = extractMin();

        }

    }

    private int parent(int index) {
        return (index - 1) / 4;
    }

    private int child(int index, int k) {
        return (4 * index) + k;
    }

    private void swap(int i, int j) {

        double temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;

    }

}
