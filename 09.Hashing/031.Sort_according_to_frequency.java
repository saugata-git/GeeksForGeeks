/*
Sort according to frequency
Time Complexity : O(n Log n)
*/
import java.util.*;

class SortComparator implements Comparator<Integer>{
    private final Map<Integer,Integer>freqMap;

    SortComparator(Map<Integer,Integer> tfreqMap){
      this.freqMap=tfreqMap;
    }

    public int compare(Integer k1,Integer k2){

        int freqCompare  = freqMap.get(k2).compareTo(freqMap.get(k1));
        int valueCompare = k1.compareTo(k2);

        if(freqCompare==0)
          return valueCompare;
        else
          return freqCompare;
    }
 }

 public class FrequencySort{

    public static void main(String args[]){
  
      int []array={ 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};
      Map<Integer,Integer> map =new HashMap<>();
      List<Integer> list =new ArrayList<>();

      for(int current : array){
          if(!map.containsKey(current)){
           map.put(current,0);
          }
          else{
              int count=map.get(current);
              map.put(current,count+1);
          }
          list.add(current);
      }
      SortComparator comp= new SortComparator(map);
      Collections.sort(list,comp);
 
      for(Integer i : list){
         System.out.print(i+" ");
      }  
    }
 }
