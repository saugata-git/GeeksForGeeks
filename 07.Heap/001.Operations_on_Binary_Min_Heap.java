// Java implementation of Min Heap 
/*
Operations on Min Heap

extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Log n) as 
this operation needs to maintain the heap property (by calling heapify()) after removing root.

insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If new key is larger 
than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by 
calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin()
to remove the key.
decreaseKey(): Decreases value of key. The time complexity of this operation is O(Logn). If the decreases key value of
a node is greater than the parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up 
to fix the violated heap property.

*/
public class Minheap { 

	public static int[] harr; 
        public static int capacity;
        public static int heap_size;
    
        Minheap(int capacity){ 
           this.capacity = capacity;
           harr = new int[capacity];
           heap_size = 0;
        } 
    
        private void swap(int source,int dest){
           int temp = harr[source];
           harr[source] = harr[dest];
           harr[dest] = temp;
        }      
  

	private void minHeapify(int pos){

          int left = 2*pos + 1;
          int right = 2*pos + 2;
          int parent = (pos-1) / 2;
          int min = pos;
    
          if(left < heap_size && harr[left] < harr[pos]){
           min = left;
          }
    
          if(right < heap_size && harr[right] < harr[min]){
           min = right;
          }
    
         if(pos!=min){
           swap(pos,min);
           minHeapify(min);
         }
       }      

        public void decreaseKey(int i, int new_val){ 
            harr[i] = new_val; 
            while (i != 0 && harr[(i-1)/2] > harr[i]) 
            { 
             swap(i,(i-1)/2); 
             i = (i-1)/2; 
            } 
         }

	public int extractMin(){
   
          if(heap_size==0){
            return -1;
          }
          int min = harr[0];
          harr[0] = harr[heap_size-1];
          heap_size--;
          minHeapify(0);
          return min;
       }

       public void insert(int k){

        if(heap_size==capacity){
           return;
        }
        harr[heap_size]=k;
        heap_size++;
        int i=heap_size-1;
        while(i!=0 && harr[i]<harr[(i-1)/2]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }

       }
       
       public void deleteKey(int i){

          if(i>=heap_size){
             return;
          }
          int delete =harr[i];
          harr[i]=harr[heap_size-1];
          heap_size--;
          minHeapify(i);
       }
 
	public void print() 
	{ 
		for (int i = 0; i <heap_size; i++) { 
			
			System.out.print(harr[i]+" "); 
		} 
	} 

	public void minHeap() 
	{ 
		for (int pos = (heap_size / 2)-1; pos >= 0; pos--) { 
			minHeapify(pos); 
		} 
	} 

	

	
	public static void main(String[] arg) 
	{ 
		System.out.println("The Min Heap is "); 
		Minheap minHeap = new Minheap(15); 
		minHeap.insert(5); 
		minHeap.insert(3); 
		minHeap.insert(17); 
		minHeap.insert(10); 
		minHeap.insert(84); 
		minHeap.insert(19); 
		minHeap.insert(6); 
		minHeap.insert(22); 
		minHeap.insert(9); 
		minHeap.minHeap(); 

		minHeap.print(); 

                System.out.println(" Minimum element is "+ minHeap.extractMin());
                minHeap.print(); 

                System.out.println(" Deleting at index-> 5 ");
                minHeap.deleteKey(5);
                minHeap.print();
                
                System.outprintln();
                minHeap.decreaseKey(4, 14);
                minHeap.print();
      }
		
} 
