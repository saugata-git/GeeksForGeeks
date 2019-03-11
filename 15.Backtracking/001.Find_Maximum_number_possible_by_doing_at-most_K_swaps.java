//Find Maximum number possible by doing at-most K swaps
import java.util.*;
import java.lang.*;

class findmax{
  static String max;

  public static int compare(String str,String max){
     int x=Integer.parseInt(str);
     int y=Integer.parseInt(max);
     return (x>y)?1:-1;
  }

  public static String swap(String str,int i,int j){
        char []ch=str.toCharArray();
        char temp= ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return new String(ch);
        
  }

  
    static void func(String str, int k){
        
        if(k==0) return;
        
        int n = str.length();
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){

                // if digit at position i is less than digit at position j, swap it and check for maximum 
                // number so far and recurse for remaining swaps 
                if(str.charAt(i)<str.charAt(j)){
                     // swap str[i] with str[j] 
                     str=swap(str,i,j);

                   /* //compare and store
                    if(str.compareTo(max)>0){
                        max=str;
                    }*/
                     // If current num is more than maximum so far 
                     if(compare(str,max)>0){
                       max=str;
                     }
                    //func, forward 
                     func(str, k-1);
                    
                    //backtrack
                    str=swap(str,i,j);
                   
                }
            }
        }
    } 

  public static void main(String args[]){
    
    
     String str="129814999";
     int k=4;
     max="0";
     func(str, k);
     System.out.println(max.equals("0")?str:max);
  }
}
