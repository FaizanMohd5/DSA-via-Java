public class Queue{
    //1. Class Queue with front, rear and ptr reference.
    private int front ;
    private int rear ;
    private Object[] ptr ;

    //2. Parameterized constructor to initialize vars
    public Queue(int size){
        front = -1;
        rear = -1;
        ptr = new Object[size];
    }

    //3. Method to insert element at rear in queue.
    public void enqueue(Object data){
        if(underflow())
            front=0;
        if(!overflow()){
            rear++;
            ptr[rear] = data;
        }
        else System.out.println("The Queue is full.");
    }

    //4. Method to view rear element of queue
    public Object getRear(){
        try {
            return ptr[rear];
        }
        catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Array index out of bounds!");
            return null;
        }
    }

    //5. Method to view front element
    public Object getFront(){
        try {
            return ptr[front];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds!");
            return null;
        }
    }

    //6. Method to delete element at front
    public void dequeue(){
        if(underflow()){
            System.out.println("The Queue is empty.");
        }
        if(front==rear){
            front=-1;
            rear=-1;
            return;
        }
        front++;
    }

    //7. Method to check queue overflow
    private boolean overflow(){
        return front==0 && rear==ptr.length-1;
    }

    //8. Method to check queue underflow
    private boolean underflow(){
        return front==-1;
    }

    //9. Method to count number of elements present in queue
    public int getCount(){
        return rear+1-front;
    }

    //printQueue
    public void printQueue() {
        if (underflow())
            System.out.println("The Queue is empty.");
        else {
            for (int i = rear; i >= front; i--)
                System.out.print(" " + ptr[i]);
            System.out.println("\nRear: " + getRear() + "\nFront: " + getFront());
            System.out.println("\nCount: " + getCount());
        }
    }

    //driver method
    public static void driver(){
        Queue queue = new Queue(5);



        queue.printQueue();
    }
}
