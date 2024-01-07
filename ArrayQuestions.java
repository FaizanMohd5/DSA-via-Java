public class ArrayQuestions
{
  //SUBARRAY QUESTIONS: A continuous part of array is called a subarray.
  
  /* 1.Print a subarray */

  //Brute force
  public static void printSubarray(int[] array){
    for(int i = 0; i < array.length; i++)  {
      int startIndex = i; // the index from where our subarray starts.
      for(int j = i; j < array.length; j++){
        int endIndex = j;
        for(int k = startIndex; k <= endIndex; k++){
          System.out.print(array[k]+" ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }

  
  public static void main(String []args)
  {
    
  }
}
