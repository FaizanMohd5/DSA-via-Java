public class StackUsingLinkedList {
    //1. Class Stack with Node type reference 'top', inner class Node.
    private Node top;
    public static class Node{
        private int item;
        private Node next;
        public int getItem() {
            return item;
        }
        public void setItem(int item) {
            this.item = item;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    //2. Method to push a new element on stack.
    public void push(int item){
        Node newNode = new Node();
        newNode.setItem(item);
        newNode.setNext(null);
        if(top!=null) {
            //insert at beginning
            newNode.setNext(top);
        }
        top = newNode;
    }

    //3. Method to peek top element of the stack.
    public Node peek() throws NullPointerException{
        if(top==null)
            System.out.println("Stack is empty");
        else
            return top;
        return null;
    }

    //4. Method to pop top element of stack.
    public Node pop(){
        if(top==null) {
            System.out.println("Stack is empty.");
            return null;
        }
        // deletion at beginning
        Node holder = top;
        top=top.getNext();
        holder.setNext(null);
        return holder;
    }

    //5. Method to reverse a stack.
    public void reverse(){
        if(top==null)
            System.out.println("Stack is empty.");
        else{
            Node iterator1 = top;
            Node iterator2 = top;
            while(iterator2.next!=null) {
                iterator2 = iterator2.next;
            }
            Node holder = iterator2;
            while ( iterator1!=iterator2 ) {
                while ( iterator1.next != iterator2 ) {
                    iterator1 = iterator1.next;
                }
                iterator2.next = iterator1;
                iterator2 = iterator1;
                iterator1 = top;
            }
            top.next = null;
            top = holder;
        }
    }

    //print
    public void printList(){
        if(top==null)
            System.out.println("Stack is empty.");
        else{
            Node iterator = top;
            while(iterator!=null){
                System.out.print(" "+iterator.item);
                iterator = iterator.next;
            }
        }
    }

    //driver
    public static void driver(){
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.reverse();

        stack.printList();

    }
}
