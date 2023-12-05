public class DynamicArray implements Sorting {
    //1. DynamicArray class with lastIndex and ptr
    private int lastIndex = -1;
    private int[] ptr;

    //2. Constructor for taking size and allocating memory
    public DynamicArray(int size) {
        ptr = new int[size];
    }

    //3. Method to double the size of array
    private void doubleArray() {
        try {
            int[] temp = new int[ptr.length * 2];
            System.arraycopy(ptr, 0, temp, 0, lastIndex + 1);
            ptr = temp;
        } catch (NullPointerException e) {
            System.out.println("doubleArray: null pointer exception");
        }
    }

    //4. Method to half the size of an array
    private void halfArray() {
        try {
            int[] temp = new int[ptr.length / 2];
            System.arraycopy(ptr, 0, temp, 0, lastIndex + 1);
            ptr = temp;
        } catch (NullPointerException e) {
            System.out.println("half array: null pointer exception");
        }
    }

    //5. Append method
    public void appendElement(int data) {
        if (lastIndex + 1 == ptr.length)
            doubleArray();
        ptr[++lastIndex] = data;
    }

    //6. Insert data at given index method
    public void insertElementAt(int index, int data) {
        try {
            if (index < 0 || index > lastIndex + 1)
                throw new ArrayIndexOutOfBoundsException("insertElementAt: invalid index");
            if (lastIndex + 1 == ptr.length)
                doubleArray();
            for (int i = lastIndex; i >= index; i--) {
                ptr[i + 1] = ptr[i];
            }
            ptr[index] = data;
            lastIndex++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    //9. Edit element at a given index method
    public void editElementAt(int index, int data) {
        try {
            if (index < 0 || index > lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            ptr[index] = data;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    //8. Delete element at a given index method
    public void deleteElementAt(int index) {
        try {
            if (index < 0 || index > lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid Index");
            if (lastIndex + 1 == ptr.length / 2 && ptr.length > 1)
                halfArray();
            for (int i = index; i < lastIndex; i++)
                ptr[i] = ptr[i + 1];
            lastIndex--;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    //9. Total number of elements present method
    public int getCount() {
        return lastIndex + 1;
    }

    //10. Check if array is empty or not method
    public boolean isArrayEmpty() {
        return lastIndex == -1;
    }

    //11. Get value stored at a specific index
    public int getValueAt(int index) {
        return ptr[index];
    }

    //12. Get capacity of array
    public int getCapacity() {
        return ptr.length;
    }

    // display method
    public void display() {
        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(ptr[i] + " ");
        }
        System.out.println("Last Index: " + lastIndex + " length of array: " + getCapacity());
    }

    //override bubble sort
    @Override
    public void bubbleSort() {
        if (isArrayEmpty())
            throw new ArrayIndexOutOfBoundsException("Array is empty.");
        boolean swapped;
        for (int round = 0; round < lastIndex; round++) {
            swapped = false;
            for (int i = 0; i < lastIndex - round; i++) {
                if (ptr[i] > ptr[i+1]) {
                    int temp = ptr[i];
                    ptr[i] = ptr[i+1];
                    ptr[i+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    //override selectionSort
    @Override
    public void selectionSort() {
        if(isArrayEmpty())
            throw new ArrayIndexOutOfBoundsException("Array is empty.");
        int min = 0;
        for (int i=0; i <= lastIndex; i++){
            min = i;
            for(int j=i+1; j <= lastIndex; j++){
                if(ptr[min] > ptr[j])
                    min = j;
            }
            int temp = ptr[i];
            ptr[i] = ptr[min];
            ptr[min] = temp;
        }
    }

    //override insertion sort

    @Override
    public void insertionSort() {
        if(isArrayEmpty())
            throw new ArrayIndexOutOfBoundsException("Array is empty.");
        if(lastIndex==0)
            return;
        int i, j;
        for(i=1; i <= lastIndex; i++){
            int pivot = ptr[i];
            for(j = i-1; j>=0 && pivot < ptr[j]; j--){
                ptr[j+1] = ptr[j];
            }
            ptr[j+1] = pivot;
        }
    }

    //override quicksort
    public int partition(int low, int high){
        int pivot = ptr[low]; //first element as pivot
        int i = low;
        int j = high;
        while(i<=j) {
            while ( pivot >= ptr[i] )
                i++;
            while ( pivot < ptr[j] )
                j--;
            if (i < j) {
                int temp = ptr[i];
                ptr[i] = ptr[j];
                ptr[j] = temp;
            }
        }
        int temp = ptr[low];
        ptr[low] = ptr[j];
        ptr[j] = temp;
        return j;
    }
    @Override
    public void quickSortCode(int low, int high){
        if(low < high){
            int loc = partition(low, high);
            //Above code will set pivot to correct position and return its index
            quickSortCode(low, loc-1);
            quickSortCode(loc+1, high);
        }
    }
    public void quickSort(){
        quickSortCode(0, lastIndex);
    }

    //merge sort
    @Override
    public void mergeSortCode(int low, int high) {
        if(low < high){
            int mid = (low + high) / 2;
            mergeSortCode(low, mid);
            mergeSortCode(mid+1, high);
            merge(low, mid, high);
        }
    }
    public void merge(int low, int mid, int high){
        //Compute size of two array
        int n1 = mid - low + 1;
        int n2 = high - mid;
        //create two arrays
        int[] a = new int[n1];
        int[] b = new int[n2];
        //noinspection ManualArrayCopy
        for(int i=0; i<n1; i++)
            a[i] = ptr[low + i];
        for(int i=0; i<n2; i++)
            b[i] = ptr[mid+1+i];
        int i = 0;
        int j = 0;
        int k = low;
        while(i < n1 && j < n2){
            if(a[i] <= b[j])
                ptr[k] = a[i++];
            else
                ptr[k] = b[j++];
            k++;
        }
        while(i < n1)
            ptr[k++] = a[i++];
        while(j < n2)
            ptr[k++] = b[j++];
    }

    void mergeSort(){
        mergeSortCode(0, lastIndex);
    }

    // driver method
    public static void driver() {
        DynamicArray dynArray = new DynamicArray(4);

        dynArray.appendElement(10);
        dynArray.appendElement(20);
        dynArray.appendElement(30);
        dynArray.appendElement(40);
        dynArray.appendElement(11);
        dynArray.appendElement(21);
        dynArray.appendElement(31);
        dynArray.appendElement(41);

        dynArray.mergeSort();
        dynArray.display();
    }
}
