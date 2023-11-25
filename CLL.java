public class CLL {
    //1. Class CLL with 'last' (ref), inner class Node with 'data' and 'next'(ref)
    private Node last;
    static class Node{
        private int data;
        private Node next;
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    //2. Check if CLL is empty.
    public boolean isLinkedListEmpty(){
        return this.last==null;
    }

    //3. Insert @ start.
    public void insertAtStart(int data){
        Node newNode = new Node();
        newNode.setData(data);
        if(last==null) {
            last = newNode;
            newNode.setNext(last);
        }
        else {
            newNode.setNext(last.next);
            last.next = newNode;
        }
    }

    //4. insert @ end
    public void insertAtEnd(int data){
        Node newNode = new Node();
        newNode.setData(data);
        if(last==null){
            last = newNode;
            newNode.setNext(last);
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    //5. Search a node of given item value.
    public Node searchNode(int data){
        if(last==null)
            return null;
        Node iterator = last.next;
        do {
            if (iterator.data == data)
                return iterator;
            iterator = iterator.next;
        } while (iterator != last.next);
        return null;
    }

    //6. Insert after a node
    public void insertAfter(int after, int data){
        Node newNode = new Node();
        newNode.setData(data);
        if(last==null){
            last = newNode;
            newNode.next = last;
        }
        else{
            Node iterator = searchNode(after);
            newNode.next = iterator.next;
            iterator.next = newNode;
            if(iterator==last)
                last = newNode;
        }
    }

    //7. Delete first node
    public void deleteFirstNode(){
        if(last==null)
            System.out.println("The list is empty.");
        else if(last.next==last)
            last=null;
        else{
            Node holder = last.next;
            last.next = last.next.next;
            holder.next=null;
        }
    }

    //8. Delete last node
    public void deleteLastNode(){
        if(last==null)
            System.out.println("The list is empty.");
        else if(last.next==last)
            last=null;
        else{
            Node holder = last;
            last=last.next;
            while(last.next!=holder)
                last = last.next;
            last.next = holder.next;
            holder.next = null;
        }
    }

    //9. Delete a specific node
    public void deleteNode(int data){
        if(last==null)
            System.out.println("The list is empty.");
        else if(last.data==data){
            deleteLastNode();
        }
        else{
            Node holder = searchNode(data);
            if(holder!=null) {
                Node iterator = last;
                while (iterator.next != holder)
                    iterator = iterator.next;
                iterator.next = holder.next;
                holder.next = null;
            }
            else
                System.out.println("Node not found.");
        }
    }

    //print
    public void printList(){
        if(last==null){
            System.out.println("This list is empty");
            return;
        }
        Node iterator = last.next;
        do {
            System.out.print(" -> " + iterator.data);
            iterator = iterator.next;
        } while (iterator != last.next);
    }

    //driver
    public static void driver(){
        CLL list = new CLL();
        list.insertAtEnd(4);

        list.printList();
    }
}
