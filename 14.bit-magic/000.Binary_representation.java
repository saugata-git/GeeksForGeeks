import java.util.*;

class DecToBin{
    public static void main(String args[]){
       
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
           int n=sc.nextInt();
           /*
              String s = Integer.toBinaryString(n);
		    for(int i=1; i<=14-s.length(); i++)
		        System.out.print("0");
		    System.out.println(s);
           */
           int res=0,count=0, multiplier = 1;;
            while(n!=0){
             int rem=n%2;
             res+= (multiplier * rem);
             multiplier *= 10;
             n=n/2;
             count++;
            }
           for(int i=0;i<14-count;i++){
                System.out.print("0");
           }
           System.out.println(res);
         }
    }
}
 
