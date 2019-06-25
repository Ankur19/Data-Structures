public class HeapSort {
    public static int[] array = null;

    public HeapSort(int[] arr){
        int[] maxHeapArray = new int[arr.length];
        int index=0;
        for (int i: arr){
            insert(i, maxHeapArray, index);
            index++;
        }
        array=maxHeapArray;
    }
    public void insert(int val, int[] heapArray, int index){
        heapArray[index] = val;
        reverseHeapify(heapArray, index);

    }
    private void reverseHeapify(int[] arr, int index){
        int parent = getParent(index);
        if (arr[index]>arr[parent]){
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
            reverseHeapify(arr, parent);
        }
    }
    public static int[] sort(){
        if (array==null){
            return new int[0];
        }
        for(int i=array.length-1;i>=0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(0,i);
        }

        return array;
    }
    private static void heapify(int startIndex, int index){
        int parent = startIndex;
        int li = 2*parent+1;
        int ri = 2*parent+2;
        int largest = parent;
        if (li<index && array[li]>array[ri] && array[li]>array[parent]){
                int temp = array[parent];
                array[parent] = array[li];
                array[li] = temp;
                largest = li;

        }
        else if (ri<index && array[li]<array[ri] && array[ri] > array[parent]){
                int temp = array[parent];
                array[parent] = array[ri];
                array[ri] = temp;
                largest = ri;
        }
        if (largest != parent){
            heapify(largest, index);
        }
    }
    private static int getParent(int index){
        int parent = 0;
        parent = (index-1)/2;
        if (parent <=0){
            return 0;
        }
        return parent;
    }

    public static int[] getArray() {
        return array;
    }



}
