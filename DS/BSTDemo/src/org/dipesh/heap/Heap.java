package org.dipesh.heap;


public class Heap {
    private int[] array;
    private int size;
    private int capacity;


    public Heap(int size, int capacity) {
        this.size = size;
        this.capacity = capacity;
        array = new int[capacity];
    }

    public Heap() {
        size = 0;
        capacity = 11;
        array = new int[capacity];
    }

    public int parent(int i) {
        if (i < 0 || i >= size) return -1;
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        int left = 2 * i + 1;
        if (left >= size) return -1;
        return left;
    }

    public int rightChild(int i) {
        int right = 2 * i + 2;
        if (right >= size) return -1;
        return right;
    }

    public int getMax() {
        if (size == 0) return -1;
        return array[0];
    }

    private void shiftUp(int i) {
        // 1. Get parent
        int parent = parent(i);
        // 2. If parent is not in the valid array range return
        if (parent > 0 && parent < size) return;

        // 3. Till index value is bigger than parent swap
        if (array[i] > array[parent]) {
            int temp = array[i];
            array[i] = array[parent];
            array[parent] = temp;
            // 4. Recursive call
            shiftUp(parent);
        }
    }

    private void shiftDown(int i) {
        if (i == -1 || i >= size) return;
        int left, right;
        int max = i;
        // 1. Get the Left and Right child Index
        left = leftChild(i);
        right = rightChild(i);

        // 2. Compare left with i if left bigger then max = left else max = i
        if (left != -1 && array[left] > array[i]) {
            max = left;
        }
        // 3. Compare right with i if right bigger then max = left
        if (right != -1 && array[right] > array[max]) {
            max = right;
        }

        // 4. If Max is different than i then swap i with max and recursive call
        if (max != i) {
            // Swap
            int tmp = array[max];
            array[max] = array[i];
            array[i] = tmp;
            // Recursive call
            shiftDown(max);
        }
    }

    public void insert(int data) {
        // 1. Resize if the size is equal or greater than capacity
        if (size >= capacity)
            resizeHeap();
        // 2. Insert the rlrmrnt at the end and then shiftUP
        size++;
        array[size] = data;
        shiftUp(size);
    }

    public int deleteMax() {
        // 1. Check the size should not be zero
        if (size == 0) return -1;
        // 2. Take out the max element from 0th location
        int data = array[0];
        // 3. Over write the 0th element with last element
        array[0] = array[size - 1];
        // 4. Decrease the size
        size--;
        // 5. Shift down the 0th element
        shiftDown(0);
        return data;
    }

    public void heapify(int[] arr) {
        // 1. If capacity is less than resize
        int n = arr.length;
        while (n > capacity) {
            resizeHeap();
        }
        // 2. Copy the old array contents to new array
        System.arraycopy(arr, 0, array, 0, n);
        // 3. Initialize the size with new array length
        size = n;
        // 4. Shift down the (n-1)/ elements from bottom up
        // Shift down is not applicable for last row hence only n-1/2 items need to be shift down
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public void heapSort(int[] arr) {
        // 1. Heapify the array
        heapify(this, arr);
        // 2. Swap the 0th item with last item
        // 3. Decrease the size by 1
        // 4. ShiftDown the 0th element
        // 5. Continuethe 2,3,4 step till size > 0
        while (size > 0) {
            int temp = array[size - 1];
            arr[size - 1] = array[0];
            array[0] = temp;
            size--;
            shiftDown(0);
        }
    }

    public void heapify(Heap h, int[] arr) {
        if (h == null) {
            System.out.println("Heap object cannot be null");
            return;
        }
        array = arr;
        size = arr.length;
        // Shift down is not applicable for last row hence only n-1/2 items need to be shift down
        for (int i = (size - 1) / 2; i >= 0; i--) {
            shiftDown(i);
        }

    }

    private void resizeHeap() {
        int newCapacity = (int) (capacity * 1.5);
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
    }
}
