public class Stack {
    //1. Class 'Stack' with 'top' and ptr(ref)
    private int top;
    private int []ptr;

    //2. Parameterized constructor to initialise member variables with given size of stack.
    public Stack(int size){
        ptr = new int[size];
        top=-1;
    }

    //3. Method to PUSH a new element on to the Stack.
    public void push(int newData){
        try{
            ptr[top+1] = newData;
            top++;
            /* we increment top after inserting, reason is that
                if an exception occurs then it would occur once top value is changed
                Instead we will first check for exception then increment.
             */
        }
        catch (Exception e){
            System.out.println("Stack is full, cannot push further.");
        }
    }

    //4. Method to POP an element from the Stack.
    public int peek() {
        int x=-11111;
        try {
            x = ptr[top];
            return x;
        }
        catch (Exception e){
            System.out.println("Stack is empty.");
        }
        return x;
    }

    //5. Method to POP element from the Stack.
    public int pop() {
        int x = -11111;
        try {
            x = ptr[top];
            top--;
            return x;
        }
        catch (Exception e){
            System.out.println("Stack is empty");
        }
        return x;
    }

    //6. Method to check stack overflow.
    public boolean stackOverflow(){
        return top>=ptr.length-1;
    }

    //7. Method to check stack underflow.
    public boolean stackUnderflow(){
        return top<=-1;
    }

    //printStack
    public void printStack(){
        if(!stackUnderflow())
            for(int i=top; i>=0; i--)
                System.out.println("index["+i+"] = "+ptr[i]);
        else System.out.println("Stack is empty.");
        System.out.println("Top = "+top);
    }

    //driver
    public static void driver(){
        Stack stack = new Stack(5);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(55);

        System.out.println(stack.stackOverflow()+" "+stack.stackUnderflow());

        stack.printStack();
    }
}
