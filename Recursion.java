public class Recursion {
    //1. print first N natural numbers
    void printNaturalNumbers(int n) {
        if (n > 0) {
            printNaturalNumbers(n - 1);
            System.out.print(" " + n);
        }
    }

    //2. print first N natural numbers in reverse
    void printNaturalNumbersInReverse(int n){
        if(n>0){
            System.out.print(" "+n);
            printNaturalNumbersInReverse(n-1);
        }
    }

    //3. print first N even natural numbers
    void printEvenNaturalNumbers(int n){
        if(n>0){
            printEvenNaturalNumbers(n-1);
            System.out.print(" "+2*n);
        }
    }

    //4. print first N even natural numbers in reverse
    void printEvenNaturalNumbersInReverse(int n){
        if(n>0){
            System.out.print(" "+2*n);
            printEvenNaturalNumbersInReverse(n-1);
        }
    }

    //5. print first N odd natural numbers
    void printOddNaturalNumbers(int n) {
        if (n > 0) {
            printOddNaturalNumbers(n - 1);
            System.out.print(" " + (2 * n - 1));
        }
    }

    //6. print first N odd natural numbers in reverse
    void printOddNaturalNumbersInReverse(int n){
        if(n>0){
            System.out.print(" "+(2*n-1));
            printOddNaturalNumbersInReverse(n-1);
        }
    }

    //7. calculate sum of first N natural numbers
    int getSumOfNaturalNumbers(int n){
        if(n==1)
            return 1;
        return n+getSumOfNaturalNumbers(n-1);
    }

    //8. calculate sum of first N even natural numbers
    int getSumOfEvenNaturalNumbers(int n){
        if(n==1)
            return 2*n;
        return 2*n + getSumOfEvenNaturalNumbers(n-1);
    }

    //9. calculate sum of first N odd natural numbers
    int getSumOfOddNaturalNumbers(int n){
        if(n==1)
            return 2*n-1;
        return 2*n-1 + getSumOfOddNaturalNumbers(n-1);
    }

    //10. calculate the factorial of a number
    int getFactorial(int n){
        if(n==0 || n==1)
            return 1;
        return n*getFactorial(n-1);
    }

    //11. calculate sum of digits of a given number.
    int sumOfDigitsIn(int n) {
        if (n > 0) {
            return n%10 + sumOfDigitsIn(n/10);
        }
        return 0;
    }

    //12. find Nth term of Fibonacci series.
    int getFibonacciAt(int n){
        if(n==0||n==1)
            return n;
        return getFibonacciAt(n-1)+getFibonacciAt(n-2);
    }

    //13. print binary of decimal
    void printBinary(int n){
        if(n>0) {
            printBinary(n / 2);
            System.out.print(n%2);
        }
    }

    //14. print octal of decimal
    void printOctal(int n){
        if(n>0) {
            printOctal(n / 8);
            System.out.print(n%8);
        }
    }

    //15. reverse a number
    int reverseNumber(int num){
        if (num == 0) {
            return 0;
        }

        // Extract the last digit of the number.
        int lastDigit = num % 10;

        // Recursively reverse the remaining digits and shift them to the left.
        int reversedNum = reverseNumber(num / 10);

        // Build the reversed number by multiplying by 10 and adding the last digit.
        return reversedNum * 10 + lastDigit;
    }

    //16. calculate sum of squares N natural numbers
    int getSumOfSquaresOf(int n){
        if(n==1)
            return 1;
        return n*n + getSumOfSquaresOf(n-1);
    }

    //driver
    public static void driver(){
        Recursion function = new Recursion();

        function.printNaturalNumbers(5);
        System.out.println();

        function.printNaturalNumbersInReverse(5);
        System.out.println();

        function.printEvenNaturalNumbers(10);
        System.out.println();

        function.printEvenNaturalNumbersInReverse(10);
        System.out.println();

        function.printOddNaturalNumbers(10);
        System.out.println();

        function.printOddNaturalNumbersInReverse(10);
        System.out.println();

        int n=7,sum;
        sum = function.getSumOfNaturalNumbers(n);
        System.out.println("Sum of "+n+" natural numbers: "+sum);

        sum = function.getSumOfEvenNaturalNumbers(n);
        System.out.println("Sum of "+n+" even natural numbers: "+sum);

        sum = function.getSumOfOddNaturalNumbers(n);
        System.out.println("Sum of "+n+" odd natural numbers: "+sum);

        sum = function.getFactorial(n);
        System.out.println(n+"!="+sum);

        sum = function.sumOfDigitsIn(123);
        System.out.println("Sum of digits in "+n+": "+sum);

        sum = function.getFibonacciAt(n);
        System.out.println("Fibonacci value at "+n+" is "+sum);

        function.printBinary(256);
        System.out.println();
        function.printOctal(256);
        System.out.println();

        sum = function.reverseNumber(1234);
        System.out.println(sum);
        System.out.println();

        sum = function.getSumOfSquaresOf(3);
        System.out.println(sum);
    }
}
