public class CDLL {
    //1. Class CDLL with 'start'(ref) and inner class Node with data, next and previous.
    private Node start;
    static class Node{
        int data;
        Node previous;
        Node next;
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getPrevious() {
            return previous;
        }
        public void setPrevious(Node previous) {
            this.previous = previous;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    //2. check is list is empty.
    public boolean isLinkedListEmpty(){
        return start==null;
    }

    //3. insert @ start
    public void insertAtStart(int data){
        Node newNode = new Node();
        newNode.setData(data);
        if(start==null){
            start=newNode;
            newNode.setNext(start);
            newNode.setPrevious(start);
        }
        else{
            newNode.next = start;
            newNode.previous = start.previous;
            start.previous.next = newNode;
            start.previous = newNode;
            start = newNode;
        }
    }

    //4. insert @ end
    public void insertAtEnd(int data){
        Node newNode = new Node();
        newNode.setData(data);
        if(start==null) {
            start = newNode;
            newNode.setNext(start);
            newNode.setPrevious(start);
        }
        else{
            newNode.next = start;
            start.previous.next = newNode;
            newNode.previous = start.previous;
            start.previous = newNode;
        }
    }

    //5. Search a node
    public Node searchNode(int data){
        Node iterator = start;
        if(iterator==null)
            return null;
        do{
            if(iterator.data==data)
                return iterator;
            iterator = iterator.next;
        } while(iterator!=start);
        return null;
    }

    //6. Insert node after a given node.
    public void insertAfter(int after, int data){
        Node newNode = new Node();
        newNode.setData(data);
        if(start==null){
            start = newNode;
            newNode.next = start;
            newNode.previous = start;
        }
        else{
            Node iterator = searchNode(after);
            newNode.setNext(iterator.getNext());
            newNode.setPrevious(iterator);
            newNode.getNext().setPrevious(newNode);
            newNode.getPrevious().setNext(newNode);
        }
    }

    //7. Delete first node
    public void deleteFirstNode(){
        if(start==null)
            System.out.println("The list is empty.");
        else{
            start.getPrevious().setNext(start.getNext());
            start.getNext().setPrevious(start.getPrevious());
            start.setNext(null);
            start = start.getPrevious().getNext();
        }
    }

    //8. Delete last node
    public void deleteLastNode(){
        if(start==null)
            System.out.println("The list is empty.");
        else if(start.next==start)
            start=null;
        else{
            Node holder = start.previous;
            start.previous.previous.next = start;
            start.previous.next = null;
            start.previous = start.previous.previous;
            holder.previous = null;
        }
    }

    //9. Delete specific node
    public void deleteNode(int data){
        if(start==null)
            System.out.println("The list is empty.");
        else if(start.next==start)
            start = null;
        else{
            Node holder = searchNode(data);
            if(holder!=null) {
                holder.getPrevious().setNext(holder.getNext());
                holder.getNext().setPrevious(holder.getPrevious());
                holder.previous = holder.next = null;
            }
            else{
                System.out.println("Element not found");
            }
        }
    }

    //print
    public void printList(){
        if(start==null)
            System.out.println("The list is empty.");
        else{
            Node iterator = start;
            do{
                System.out.print(" -> "+iterator.getData());
                iterator = iterator.getNext();
            } while(iterator!=start);
        }
    }

    //driver
    static void driver(){
        CDLL list = new CDLL();
        list.insertAtEnd(2);
        list.deleteNode(1);

        list.printList();
    }
}
