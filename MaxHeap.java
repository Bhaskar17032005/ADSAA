import java.util.*;

class MaxHeap {
    int[] A;
    int maxsize, heapsize;

    MaxHeap(int ms) {
        A = new int[ms];
        maxsize = ms;
        heapsize = 0;
    }

    int lchild(int i) {
        return 2 * i + 1;
    }

    int rchild(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void insertKey(int x) {
        if (heapsize == maxsize) {
            System.out.println("Heap Overflow");
            return;
        }
        int i = heapsize;
        A[i] = x;
        heapsize++;
        while (i != 0 && A[parent(i)] < A[i]) {
            int temp = A[i];
            A[i] = A[parent(i)];
            A[parent(i)] = temp;
            i = parent(i);
        }
    }

    void removeMax() {
        if (heapsize <= 0) {
            System.out.println("Heap is empty");
            return;
        }
        if (heapsize == 1) {
            heapsize--;
        } else {
            A[0] = A[heapsize - 1];
            heapsize--;
            heapify(0);
        }
    }

    void heapify(int i) {
        int l = lchild(i);
        int r = rchild(i);
        int largest = i;
        if (l < heapsize && A[l] > A[largest]) {
            largest = l;
        }
        if (r < heapsize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapify(largest);
        }
    }

    int getMax() {
        return A[0];
    }

    int currentSize() {
        return heapsize;
    }

    public static void main(String args[]) {
        MaxHeap h = new MaxHeap(15);
        int elements[] = {3, 10, 12, 8, 2, 14};
        for (int e : elements) {
            h.insertKey(e);
        }
        System.out.println("The current size of heap is " + h.currentSize());
        System.out.println("The current maximum element in the heap is " + h.getMax());
        h.removeMax();
        System.out.println("The current size of heap is " + h.currentSize());
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of heap is " + h.currentSize());
        System.out.println("The current maximum element in the heap is " + h.getMax());
    }
}
/* output:-
The current size of heap is 6
The current maximum element in the heap is 14
The current size of heap is 5
The current size of heap is 7
The current maximum element in the heap is 15
*/
  
  
