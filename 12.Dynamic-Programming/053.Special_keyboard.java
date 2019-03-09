//T(n)=O(n)
import java.io.*; 
  
class MaxAs{ 
   
    static int findoptimal(int N) 
    { 
       
        if (N <= 6) 
            return N; 
      
       
        int screen[] = new int[N]; 
      
        int b;
        int n; 
        for (n = 1; n <= 6; n++) 
            screen[n - 1] = n; 
      
      
        for (n = 7; n <= N; n++) 
        { 
            int mul=2;
            screen[n - 1] = 0; 
            for (b = n - 3; b >= 1; b--) 
            { 
                int curr = mul * screen[b - 1]; //int curr = (n - b - 1) * screen[b - 1]; 
                if (curr > screen[n - 1]) 
                    screen[n - 1] = curr; 
                mul+=1;
            } 
        } 
        return screen[N - 1]; 
    } 
      

    public static void main(String [] args) 
    { 
        int N; 
        for (N = 1; N <= 20; N++) 
            System.out.println("Maximum Number of A's with keystrokes is "+  N +"->"+ findoptimal(N)); 
    } 
  }
