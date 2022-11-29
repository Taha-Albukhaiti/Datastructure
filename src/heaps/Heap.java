

package heaps;

import java.util.Arrays;

public class Heap {
    private int[] arr;
    int heapSize;

    public Heap(int[] arr) {
        this.arr = arr;
        this.heapSize = arr.length;
        this.buildMaxHeap();
    }

    private int left(int i) {
        return i == 0 ? 1 : 2 * i;
    }

    private int right(int i) {
        return i == 0 ? 2 : 2 * i + 1;
    }

    private int parent(int i) {
        return i != 1 && i != 2 ? i / 2 : 0;
    }

    private void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int max;
        if (l < this.heapSize && this.arr[l] > this.arr[i]) {
            max = l;
        } else {
            max = i;
        }

        if (r < this.heapSize && this.arr[r] > this.arr[max]) {
            max = r;
        }

        this.swap(this.arr, max, i);
        if (max != i) {
            this.maxHeapify(max);
        }

    }

    private void minHeapify(int i) {
        int l = this.left(i);
        int r = this.right(i);
        int min;
        if (l < heapSize && arr[l] < arr[i]) {
            min = l;
        } else {
            min = i;
        }

        if (r < heapSize && this.arr[r] < arr[min]) {
            min = r;
        }

        swap(arr, min, i);
        if (min != i) {
            minHeapify(min);
        }

    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    protected void buildMaxHeap() {
        for (int i = (this.heapSize - 1) / 2; i >= 0; --i) {
            this.maxHeapify(i);
        }

    }

    protected void buildMinHeap() {
        for (int i = (this.heapSize - 1) / 2; i >= 0; --i) {
            this.minHeapify(i);
        }

    }

    protected void heapSort() {
        for (int i = heapSize - 1; i >= 1; --i) {
            swap(this.arr, 0, i);
            heapSize--;
            maxHeapify(0);
        }

    }

    protected int delete() {
        int max = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        maxHeapify(0);
        return max;
    }

    protected int getMax() {
        return this.arr[0];
    }

    protected int getMin() {
        return arr[arr.length - 1];
    }

    protected void increaseKey(int i, int wert) {
        arr[i] = wert;
        while (i > 1 && arr[parent(i)] < arr[i]) {
            swap(arr, i, parent(i));
        }

    }

    protected void insert(int k) {
        if (heapSize < arr.length) {
            heapSize += 1;
            arr[heapSize - 1] = 0;
            increaseKey(heapSize - 1, k);
        }
    }

    protected int getSize() {
        return heapSize;
    }
}

class HeapSort {

    public static void main(String[] args) {
        int[] heap = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heap h = new Heap(heap);
        //h.increaseKey(3, 13);
        h.delete();
        h.insert(21);
        Arrays.stream(heap).forEach(System.out::println);
        System.out.println();
        System.out.println();
    }
}
