public class DynamicArray {
    //1. DynamicArray class with lastIndex and ptr
    private int lastIndex=-1;
    private Object[] ptr;

    //2. Constructor for taking size and allocating memory
    public DynamicArray(int size){
        ptr = new Object[size];
    }

    //3. Method to double the size of array
    private void doubleArray(){
        try {
            Object[] temp = new Object[ptr.length*2];
            System.arraycopy(ptr, 0, temp, 0, lastIndex + 1);
            ptr = temp;
        }
        catch (NullPointerException e){
            System.out.println("doubleArray: null pointer exception");
        }
    }

    //4. Method to half the size of an array
    private void halfArray(){
        try{
            Object[] temp = new Object[ptr.length/2];
            System.arraycopy(ptr,0,temp,0,lastIndex+1);
            ptr = temp;
        }
        catch (NullPointerException e){
            System.out.println("half array: null pointer exception");
        }
    }

    //5. Append method
    public void appendElement(Object data){
            if(lastIndex+1==ptr.length)
                doubleArray();
            ptr[++lastIndex]=data;
    }

    //6. Insert data at given index method
    public void insertElementAt(int index, Object data){
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
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    //9. Edit element at a given index method
    public void editElementAt(int index, Object data){
        try {
            if (index < 0 || index > lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            ptr[index] = data;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    //8. Delete element at a given index method
    public void deleteElementAt(int index){
        try {
            if (index < 0 || index > lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid Index");
            if (lastIndex + 1 == ptr.length / 2 && ptr.length>1)
                halfArray();
            for (int i = index; i < lastIndex; i++)
                ptr[i] = ptr[i + 1];
            lastIndex--;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    //9. Total number of elements present method
    public int getCount(){
        return lastIndex+1;
    }

    //10. Check if array is empty or not method
    public boolean isArrayEmpty(){
        return lastIndex==-1;
    }

    //11. Get value stored at specific index
    public Object getValueAt(int index){
        return ptr[index];
    }

    //12. Get capacity of array
    public int getCapacity(){
        return ptr.length;
    }
}