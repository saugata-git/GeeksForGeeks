import java.util.*;

class Element{
      int listIndex;
      int value;
      Element(int a,int b){
        this.listIndex=a;
        this.value=b;
      }
}

public class ShortestRange{

   public static void swap(Element []array,int i,int j){

      Element tmp=array[i];
      array[i]=array[j];
      array[j]=tmp;
   }

   public static void minHeapify(Element []array,int curIndex,int heapSize){

    int left=2*curIndex+1;
    int right=2*curIndex+2;
    int smallest=curIndex;
   
    if(left<heapSize && array[left].value<array[smallest].value){
        smallest=left;
    }
    if(right<heapSize && array[right].value<array[smallest].value){
        smallest=right;
    }
    if(smallest!=curIndex){
        swap(array,curIndex,smallest);
        minHeapify(array,smallest,heapSize);
    }
   }

   public static void buildMinHeap(Element[] array,int heapSize){
     int n=array.length-1;
     for(int i=(n-1)/2;i>=0;i--){
       minHeapify(array,i,heapSize);
     }
   }

   public static void shortestRange(int [][]A){

      int[]  pointers=new int[A.length];
      Element[] minHeap =new Element[A.length];
      int minRange=Integer.MAX_VALUE;
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      int finalMin=Integer.MAX_VALUE;
      int finalMax=Integer.MIN_VALUE;
    
      for(int i=0;i<A.length;i++){

           int []tempList=A[i];
           if(tempList.length>0){
               minHeap[i]=new Element(i,tempList[0]);
               if(tempList[0]>max){
                 max=tempList[0];
               }
           }
           else{
               System.out.println("One of the lists is empty");
               return;
           }
      }
     
      while(true){

          buildMinHeap(minHeap, minHeap.length);
          Element minElement=minHeap[0];
          int listIndex=minElement.listIndex;
          min=minElement.value;


          if((max-min)<minRange){
             finalMax=max;
             finalMin=min;
             minRange=max-min;
          }

          if((pointers[listIndex]+1)<A[listIndex].length){

              pointers[listIndex]++;
              Element nextElement= new Element(listIndex, A[listIndex][pointers[listIndex]]);
               if(nextElement.value>max){
                 max=nextElement.value;
                }
              minHeap[0]=nextElement;
          }

         else{
            System.out.println("{" + finalMin + "," + finalMax + "}");
            return;  
         }
      }
  }




   public static void main(String args[]){

        int [][]A={ { 4,10,15,24,26},
                    { 0,9,12,20},
                    { 5,18,22,30}
                  };
         shortestRange(A);
   }
}
