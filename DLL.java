import org.jetbrains.annotations.NotNull;

public class DLL {
    //1. Class DLL with start(ref), inner class node with data, prev(ref), next(ref)
    private Node start;
    private static class Node{
        int data;
        Node previous;
        Node next;
        public void setData(int data){
            this.data = data;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setPrevious(Node previous){
            this.previous = previous;
        }
        public int getData() {
            return data;
        }
        public Node getNext() {
            return next;
        }
        public Node getPrevious() {
            return previous;
        }
    }

    //2. Check if doubly linked list is empty.
    public boolean isLinkedListEmpty(){
        return start==null;
    }

    //3. Insert node at the beginning of list
    public void insertNodeAtBeginning(int data){
        Node newnode = new Node();
        newnode.setData(data);
        newnode.setPrevious(null);
        if(start!=null) {
            newnode.setNext(start);
            start.setPrevious(newnode);
        }
        start = newnode;
    }

    //4. insert node at the end of list
    public void insertNodeAtEnd(int data){
        Node newnode = new Node();
        newnode.setData(data);
        newnode.setPrevious(null);
        newnode.setNext(null);
        if(start==null)
            start = newnode;
        else{
            Node iterator=start;
            while(iterator.next!=null)
                iterator = iterator.getNext();
            iterator.next = newnode;
            newnode.previous = iterator;
        }
    }

    //5. Search a node of given value
    public Node searchNode(int data){
        if(start!=null){
            Node iterator = start;
            while(iterator!=null){
                if(iterator.getData()==data)
                    return iterator;
                iterator = iterator.getNext();
            }
        }
        return null;
    }

    //6. insert a node after a node
    public void insertNodeAfter(int after, int data){
        Node newnode = new Node();
        newnode.setData(data);
        if(start==null)
            start = newnode;
        else{
            Node iterator = searchNode(after);
            if(iterator==null){
                System.out.println("Node specified not found");
                return;
            }
            iterator.next.previous = newnode;
            newnode.next = iterator.next;
            newnode.previous = iterator;
            iterator.next = newnode;
        }
    }

    //7. Delete first node of list
    public void deleteFirstNode(){
        if(start==null)
            System.out.println("List is empty.");
        else{
            Node holder = start;
            start = start.next;
            holder.next.previous = null;
            holder.next = null;
        }
    }

    //8. Delete last node of list
    public void deleteLastNode(){
        if(start==null)
            System.out.println("List is empty.");
        else if(start.next==null)
            start = null;
        else{
            Node iterator = start;
            while(iterator.next.next!=null)
                iterator = iterator.next;
            iterator.next.previous = null;
            iterator.next = null;
        }
    }

    //9. Delete a node with given data value. If multiples then delete which occurred first
    public void deleteNode(int data){
        if(start==null)
            System.out.println("List is empty.");
        else{
            Node iterator = searchNode(data);
            iterator.previous.next = iterator.next;
            iterator.next.previous = iterator.previous;
            iterator.previous = null;
            iterator.next = null;
        }
    }

    //print
    void print(Node iterator){
        if(iterator==null)
            return;
        System.out.print(" -> "+iterator.data);
        print(iterator.next);
    }
    //driver
    static void driver(){
        DLL list = new DLL();

        list.deleteLastNode();



        list.print(list.start);
    }
}
