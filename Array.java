public class Array {
    //1. Array class with lastIndex & ptr
    private int lastIndex=-1;
    private final Object[] ptr;

    //2. Constructor for allocating memory to array
    public Array(int size){
        ptr = new Object[size];
    }

    //3. append element (at insertion at last)
    public void appendElement(Object data) {
        try {
            ptr[++lastIndex] = data;
        } catch (ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Array Overflow");
        }
    }
    //4. insert element at given index
    public void insertElement(int index, Object data){
        try{
            if(index<0 || index>lastIndex+1)
                throw new ArrayIndexOutOfBoundsException();
            for(int i=lastIndex;i>=index;i--){
                ptr[i+1]=ptr[i];
            }
            ptr[index] = data;
            lastIndex++;
        } catch(ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Array Index out of bounds");
        }
    }

    //5. Edit element at given index
    public void editElement(int index, Object data){
        try{
            if(index<0 || index>lastIndex)
                throw new ArrayIndexOutOfBoundsException();
            ptr[index]=data;
        } catch (ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Array index out of bounds");
        }
    }
    //6. delete an element at given index

    public void deleteElementAt(int index){
        try{
            if(index<0 || index>lastIndex)
                throw new ArrayIndexOutOfBoundsException();
            for(int i=index;i<lastIndex;i++)
                ptr[i]=ptr[i+1];
            lastIndex--;
        } catch (ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Array out of bounds");
        }
    }

    //7. Get count of elements
    public int getElementsCount(){
        return lastIndex+1;
    }

    //8. Check if array is Empty or not
    public boolean isArrayEmpty(){
        return lastIndex==-1;
    }

    //9. Check if array is Full or not
    public boolean isArrayFull(){
        return lastIndex+1==ptr.length;
    }

    // 10. Get value at a given index
    public Object getValueAt(int index){
        try {
            return ptr[index];
        } catch(ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Array index out of bounds");
        }
        return null;
    }

    // 11. Check array Capacity
    public int getCapacity(){
        return ptr.length;
    }
}
