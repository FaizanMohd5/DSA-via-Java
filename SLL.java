public class SLL {
    //1. Class SLL with inner class Node(with data and )
    private Node start;
    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public int getData() {
            return data;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getNext() {
            return next;
        }
    }

    //2. check if linked list is empty
    public boolean isLinkedListEmpty(){
        return start==null;
    }

    //3. insertion at beginning
    public void insertNodeAtBeginning(int data){
        Node newnode = new Node(data);
        if(start!=null)
            newnode.next=start;
        start=newnode;
    }

    //4. insertion at end
    public void insertNodeAtEnd(int data){
        Node newnode = new Node(data);
        if (start == null) {
            start = newnode;
            return;
        }
        Node iterator = start;
        while (iterator.next != null)
            iterator = iterator.next;
        iterator.next = newnode;
    }

    //5. Search at node of given data value
    public Node searchNode(int data){
        Node iterator = start;
        if (start != null) {
            while (iterator!= null) {
                if (iterator.data == data)
                    return iterator;
                iterator = iterator.next;
            }
        }
        return null;
    }

    //6. insertion after a node
    public void insertNodeAfter(int after,int data){
        Node newnode = new Node(data);
        if (start == null){
                start = newnode;
                return;
        }
        Node iterator = start;
        while (iterator != null) {
            if(iterator.data==after) {
                newnode.next = iterator.next;
                iterator.next = newnode;
                return;
            }
            iterator = iterator.next;
        }
        System.out.println("Node specified not found.");
    }

    //7. delete first node
    public void deleteNodeAtBeginning(){
        if (start != null) {
            Node holder = start;
            start = start.next;
            holder.next = null;
            return;
        }
        System.out.println("List is empty.");
    }

    //8. delete last node
    public void deleteNodeAtEnd(){
            if(start.next==null)
                start=null;
            else if (start != null) {
                Node iterator = start;
                while (iterator.next.next != null) {
                    iterator = iterator.next;
                }
                iterator.next = null;
                return;
            }
            System.out.println("List is empty.");
    }

    //9. Delete a specific node
    public void deleteNode(int data) {
        if(isLinkedListEmpty()){
            System.out.println("List is empty.");
            return;
        }
        Node iterator = start;
        Node holder = iterator.next;
        while (holder.data != data) {
            iterator = iterator.next;
            holder = iterator.next;
        }
        iterator.next = holder.next;
        holder.next = null;
    }

    //display
    public void printList(Node iterator){
            System.out.print(" -> " + iterator.data);
            if(iterator.next!=null)
                printList(iterator.next);
    }

    //driver
    public static void driver(){
        SLL linkedList = new SLL();

        linkedList.insertNodeAtBeginning(2);
        linkedList.insertNodeAfter(2,3);
        linkedList.insertNodeAtBeginning(1);
        linkedList.insertNodeAtEnd(6);
        linkedList.insertNodeAfter(3,5);
        linkedList.insertNodeAfter(3,4);
        linkedList.insertNodeAfter(4,4);

        linkedList.deleteNode(4);
        linkedList.deleteNodeAtBeginning();
        linkedList.deleteNodeAtEnd();

        linkedList.printList(linkedList.start);
    }
}
