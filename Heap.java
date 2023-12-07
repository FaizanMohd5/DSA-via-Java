public class Heap {
    //1. Class Heap with lastIndex and ptr reference to array.
    private int lastIndex;
    private final int[] ptr;
    //2. Parameterized constructor to create heap of given size.
    public Heap(int size){
        ptr = new int[size];
        lastIndex = -1;
    }
    //3. Insert data in heap
    public void insert(int data){
        if(lastIndex==-1)
            ptr[++lastIndex] = data;
        else{
            int index, parentIndex;
            for(index = lastIndex+1; index>0; index=parentIndex){
                parentIndex = (index-1)/2;
                if(ptr[parentIndex] < data){
                    ptr[index] = ptr[parentIndex];
                }
                else break;
            }
            ptr[index] = data;
            lastIndex++;
        }
    }
    //4. Return top(or max) element (no deletion)
    public int getTop() throws ArrayIndexOutOfBoundsException{
        if(lastIndex==-1)
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        else
            return ptr[0];
    }
    //5. Delete data in heap (only root gets deleted)
    public int delete() throws ArrayIndexOutOfBoundsException{
        int item;
        if(lastIndex==-1)
            throw new ArrayIndexOutOfBoundsException("Heap is empty.");
        else{
            item = ptr[0];
            int temp = ptr[lastIndex];
            lastIndex--;

            int index = 0, leftIndex = 1, rightIndex = 2;

            while(leftIndex < lastIndex){
                if(ptr[leftIndex] > ptr[rightIndex]){
                    if(temp < ptr[leftIndex]){
                        ptr[index] = ptr[leftIndex];
                        index = leftIndex;
                    }
                    else break;
                }
                else {
                    if(temp < ptr[rightIndex]){
                        ptr[index] = ptr[rightIndex];
                        index = rightIndex;
                    }
                    else break;
                }
                leftIndex = 2*index+1;
                rightIndex = 2*index+2;
            }
            if(leftIndex==lastIndex && temp < ptr[leftIndex]){
                ptr[index] = ptr[leftIndex];
                index = leftIndex;
            }
            ptr[index] = temp;
        }
        return item;
    }
    //print
    public void print(){
        if(lastIndex > -1){
            for(int i=0; i <= lastIndex; i++)
                System.out.print(" "+ptr[i]);
        }
    }

    //driver
    public void driver(){
        Heap heap = new Heap(10);
        heap.insert(35);
        heap.insert(90);
        heap.insert(40);
        heap.insert(95);
        heap.insert(40);
        heap.insert(70);
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.print();
    }
}
