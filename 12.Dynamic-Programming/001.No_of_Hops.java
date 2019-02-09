// Java program to count number of ways to cover a distance with 1, 2 and 3 steps 

public class dp{
   
    //bottom up function
     static public int printCountDp2(int dist){
      int count[] =new int [dist+1];
      
      count[0]=1;
      count[1]=1;
      count[2]=2;
      for(int i=3;i<=dist;i++){
        count[i]=count[i-1]+count[i-2]+count[i-3];
      }
      return count[dist];
    }

    public static void main (String args[]){ 
        dp ob= new dp();
        int dist = 4; 
        System.out.println(ob.printCountDp2(dist)); 
    }
 
}
