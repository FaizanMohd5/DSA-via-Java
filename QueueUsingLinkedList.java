public class QueueUsingLinkedList {
    //1. Node type reference variables, front and rear variables. Using SLL
    static class Node{
        private Object item;
        private Node next;
    }
    Node front;
    Node rear;

    //2. Constructor to initialise member variable
    public QueueUsingLinkedList(){
        front = null;
        rear = null;
    }

    //3. Insert new element rear in the queue
    public void enqueue(int data){
        Node newNode = new Node();
        newNode.item = data;
        newNode.next = null;
        if(front==null && rear==null)
            front = newNode;
        else
            rear.next = newNode;
        rear = newNode;
    }

    //4. View rear element
    public Object getFront() {
        return front.item;
    }

    //5. View front element
    public Object getRear() {
        return rear.item;
    }

    //6. Delete element at front in the queue
    public void dequeue(){
        if(front==null && rear==null)
            System.out.println("The Queue is empty.");
        else if(front==rear){
            front = null;
            rear =  null;
        }
        else{
            Node holder = front;
            front = front.next;
            holder.next = null;
        }
    }

    //printQueue
    public void printQueue(){
        Node iterator = front;
        if(iterator==null)
            System.out.println("The Queue is empty.");
        else{
            while(iterator.next!=null){
                System.out.print(" "+iterator.item);
                iterator = iterator.next;
            }
        }
    }

    //driver
    public static void driver(){
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(2);
    }
}
