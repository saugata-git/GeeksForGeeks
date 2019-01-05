 
  
class Main 
{ 
    // Print all subsets of given set[] 
    static void printSubsets(char set[]) 
    { 
        int n = set.length; 
  
        // Run a loop for printing all 2^n 
        // subsets one by obe 
        for (int i = 0; i < (1<<n); i++) 
        { 
            System.out.print("{ "); 
  
            // Print current subset 
            for (int j = 0; j < n; j++) 
  
                // (1<<j) is a number with jth bit 1 
                // so when we 'and' them with the 
                // subset number we get which numbers 
                // are present in the subset and which 
                // are not 
                if ((i & (1 << j)) > 0) 
                    System.out.print(set[j] + " "); 
  
            System.out.println("}"); 
        } 
    } 
  

    static char[] printDistinct(char arr[]) 
    { 
        int k=0;
        char []ar=new char[arr.length];
        
        // Pick all elements one by one 
        for (int i = 0; i < arr.length; i++) 
        { 
            // Check if the picked element  
            // is already printed 
            int j; 
            for (j = 0; j < i; j++) 
            if (arr[i] == arr[j]) 
                break; 
      
            // If not printed earlier,  
            // then print it 
            if (i == j){ 
              ar[k]= arr[i];
               k++;
           
            }
        } 
      //for avoiding extra garbage value in array
       char []array=new char[k];
       for(int i=0;i<k;i++){
        array[i]=ar[i];
        }
       return array;
    } 
    // Driver code 
    public static void main(String[] args) 
    { 
        char set[] = {'a', 'b', 'c','b','c'};
       

        
       char []array=printDistinct(set);
       
       printSubsets(array); 
    } 
} 
