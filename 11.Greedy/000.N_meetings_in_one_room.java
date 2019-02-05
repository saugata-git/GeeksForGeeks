import java.util.*;

class Meeting{

   int id;
   int start;
   int finish;
   Meeting(int id,int start,int finish){
   this.id=id;
   this.start=start;
   this.finish=finish;
   }
   
}

class SortByFinish implements Comparator<Meeting>{
   public int compare(Meeting m1,Meeting m2){
     return m1.finish-m2.finish;
   }
}

class Driver{

     public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int t=sc.nextInt();
      while(t-->0){
      
        int n=sc.nextInt();
        int []s= new int[n];
        int []f= new int[n];
        for(int i=0;i<n;i++){
          s[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
          f[i]=sc.nextInt();
        }
        
        Meeting []m= new Meeting[n];
        for(int i=0;i<n;i++){
          m[i]= new Meeting(i+1,s[i],f[i]);
        }  
        
        Arrays.sort(m, new SortByFinish());
        System.out.println(m[0].finish + " ");
        int e=m[0].finish;
        
        for(int i=1;i<n;i++){
            if(m[i].start>e){
             System.out.println(m[i].id);
             e=m[i].start;
            }
        }
        System.out.println();
        
      }
     }
}

