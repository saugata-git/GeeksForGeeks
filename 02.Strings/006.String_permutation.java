/*
String Permutation
Algorithm Paradigm: Backtracking
Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.
*/
public class Permutation{
 
  public static String swap(String a,int i,int j){
    char temp;
    char[] charArray=a.toCharArray();
    temp=charArray[i];
    charArray[i]=charArray[j];
    charArray[j]=temp;
    return String.valueOf(charArray);
  }  

  public static void permute(String str,int l,int r){
    if(l==r){
       System.out.println(str);
    }
    else{
      for(int i=l;i<=r;i++){
         str=swap(str,l,i);
         permute(str,l+1,r);
         str=swap(str,l,i);//backtrack
      }
    }
  }
   
  public  static void main(String args[]){
    String str="ABC";
    int n=str.length();
    permute(str,0,n-1);
  }
 
}
