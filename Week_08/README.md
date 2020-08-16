学习笔记
各种排序算法
```
    /*冒泡排序*/
    static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*选择排序*/
    static void selectionSort(int[] arr) {
        int length = arr.length;
        int minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }

    /*插入排序*/
    static void insertSort(int[] arr) {
        int length = arr.length;
        int preIndex, current;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    static void insertSortII(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > curr) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = curr;
        }

    }

    /*归并排序*/
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }
    }


    /*归并排序*/
    static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


    /*快速排序*/
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int begin, int end) {
        // pivot:标杆位置；counter：小于pivot的元素个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }

    /*堆排序*/
    public static void heapSort(int[] array) {
        int length = array.length;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            queue.add(array[i]);
        }
        for (int i = 0; i < length; i++) {
            array[i] = queue.poll();
        }
    }

```