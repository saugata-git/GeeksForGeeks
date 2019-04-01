/*
Find the first repeating element in an array of integers
O(n) time
*/

import java.util.*;
class FirstRepeating{

  static void printFirstRepeating(int arr[]){
      int ele=-1;
      HashSet<Integer> set =new HashSet<Integer>();
      for(int i=0;i<arr.length;i++){
           if(set.contains(arr[i])){
              ele=arr[i];
              break;
           }
           else
              set.add(arr[i]);
      }
     System.out.println("The first repeating element is :"+ ele);
  }

  public static void main(String args[]){
     int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
     printFirstRepeating(arr); 
  }
}
