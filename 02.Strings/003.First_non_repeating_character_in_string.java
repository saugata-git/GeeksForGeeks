import java.util.Scanner;
class FNRC{
  
   public static Character getFNCR(String string){
      if(string==null || string.length()==0)
        return null;
      int n=string.length();
      if(n==1){
         return string.charAt(0);
      }
      int []charIdx =new int[256];
      for(int i=0;i<256;i++){
       charIdx[i]=-1;
      }

     for(int i=0;i<n;i++){
       if(charIdx[string.charAt(i)]==-1){
          // character seen first time
         charIdx[string.charAt(i)]=i;
       }
       else{
          // Repeated character
         charIdx[string.charAt(i)]=-2;
       }
     }
     int minIdx=n;
     for(int i=0;i<256;i++){
      if(charIdx[i]>=0 && minIdx>charIdx[i]){
         minIdx=charIdx[i];
      }
     }
    return (minIdx >= 0 && minIdx < n)?string.charAt(minIdx) :null;
   }
   public static void main(String args[]){
     Scanner sc =new Scanner(System.in);
     int t;
     t=sc.nextInt();
     sc.nextLine();
     while(t-->0){
      String string;
      string=sc.nextLine();
      System.out.println(getFNCR(string));


     }
   }

}
