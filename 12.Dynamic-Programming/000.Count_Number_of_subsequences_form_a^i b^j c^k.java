// Java program to count subsequences of the form a^i b^j c^k 
//Time Complexity : O(n)

public class Nos{

     static int countsub(String s){
         int aCount=0;
         int bCount=0;
         int cCount=0;
         for(int i=0;i<s.length();i++){
              if(s.charAt(i)=='a')
                   aCount=(1+2*aCount);
              else if(s.charAt(i)=='b')
                   bCount=(aCount+2*bCount);
              else if(s.charAt(i)=='c')
                   cCount=(bCount+2*cCount);
         }
       return cCount;
     }
    public static void main(String args[]){
        String s="abcabc";
        System.out.println(countsub(s));
    }
}
