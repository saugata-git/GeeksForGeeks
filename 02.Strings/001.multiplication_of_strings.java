import java.util.*;

class karatsuba{
      
       public static int round_n(double x)
       { 
            if (x < 0.0)
               return (int)(x - 0.5);
            else
            return (int)(x + 0.5);
       }


       public static double pow_n(double x,double y){
           double temp;
           if(y==0)
            return 1;
           temp=pow_n(x,y/2);
           if(y%2==0)
            return temp*temp;
           else{
             if(y>0){
             return x*temp*temp;
             }
             else
               return (temp*temp)/x;
           }

       }

       public static double max_n(double x,double y){
  
          if(x>y)
            return x;
          else 
            return y;
       }

      public static long strToInt( String str ){
        int i = 0;
        long num = 0;
        boolean isNeg = false;
  
        //Check for negative sign; if it's there, set the isNeg flag
        if (str.charAt(0) == '-') {
           isNeg = true;
           i = 1;
        }

        //Process each character of the string;
        while( i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
        }

        if (isNeg)
           num = -num;
        return num;
      }


      public static long karatsubamul(long x,long y){
         if(x<10 || y<10)
           return x*y;

         // get the length of longest number
         int maxBase= (int)max_n(Math.log10(x),Math.log10(y))+1;

         int halfMax=round_n(maxBase/2);
         //int halfMax = (maxBase/2) + (maxBase%2); // also valid

         long a=x/(int)pow_n(10,halfMax);
         long b=x%(int)pow_n(10,halfMax);
         long c=y/(int)pow_n(10,halfMax);
         long d=y%(int)pow_n(10,halfMax);
         
         long ac =karatsubamul(a,c);
         long bd =karatsubamul(b,d);
         long abcd=karatsubamul((a+b),(c+d));
         abcd=abcd-ac-bd;

         return (long)((ac*pow_n(10,(2*halfMax)))+(abcd*pow_n(10,halfMax))+bd);
 
       }

    
      public static void main(String args[]){
    
      Scanner sc =new Scanner(System.in);
      int t = sc.nextInt();
       sc.nextLine();
       
      while(t-->0){
        String x =sc.nextLine();
        String y =sc.nextLine();
        long a =strToInt(x);
        long b=strToInt(y); 
        System.out.println(karatsubamul( a,b));
      }
      }
}
