package heaps;

import java.util.Arrays;

public class Heap {
    private int[] arr;
    private int heapSize;

    public Heap(int[] arr) {
        this.arr = arr;
        this.heapSize = arr.length;
        //buildMaxHeap();
        // heapSort();
    }

    private int left(int i) {
        if (i == 0) return 1;
        return 2 * i;
    }

    private int right(int i) {
        if (i == 0) return 2;
        return (2 * i) + 1;
    }

    private int parent(int i) {
        return i / 2;
    }

    private void maxHeapify(int i) {

        int l = left(i);
        int r = right(i);
        int max;
        if (l < heapSize && arr[l] > arr[i]) max = l;
        else max = i;

        if (r < heapSize && arr[r] > arr[max]) max = r;
        swap(arr, max, i);

        if (max != i) {
            maxHeapify(max);
        }
    }
    private void minHeapify(int i) {

        int l = left(i);
        int r = right(i);
        int min;
        if (l < heapSize && arr[l] < arr[i]) min = l;
        else min = i;

        if (r < heapSize && arr[r] < arr[min]) min = r;
        swap(arr, min, i);

        if (min != i) {
            minHeapify(min);
        }
    }
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    protected void buildMaxHeap() {
        for (int i = (heapSize - 1) / 2 ; i >= 0; i--) maxHeapify(i);
    }
    protected void buildMinHeap() {
        for (int i = (heapSize - 1) / 2 ; i >= 0; i--) minHeapify(i);
    }
    protected void heapSort(){
        for (int i = heapSize - 1; i >= 1; i--){
            swap(arr, 0, i);
            heapSize--;
            minHeapify(0);
        }
    }


}

class HeapSort {

    public static void main(String[] args) {
        int[] heap = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heap h = new Heap(heap);
        h.buildMinHeap();
        //h.heapSort();


        Arrays.stream(heap).forEach(System.out::println);
        System.out.println();
        System.out.println();
    }
}