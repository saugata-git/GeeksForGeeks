/*The idea is to use min heap. Following are detailed step.
1) Build a min heap of elements from first row. A heap entry also stores row number and column number.
2) Do following k times.
…a) Get minimum element (or root) from min heap.
…b) Find row number and column number of the minimum element.
…c) Replace root with the next element from same column and min-heapify the root.
3) Return the last extracted root.
Time Complexity: The above solution involves following steps.
1) Build a min heap which takes O(n) time
2) Heapify k times which takes O(kLogn) time.
Therefore, overall time complexity is O(n + kLogn) time.

*/
class HeapNode {
        int data, r, c;

        public HeapNode() {
          this.data = data;
          this.r = r;
          this.c = c;
        }

        public  HeapNode(HeapNode node) {
         this.data = node.data;
         this.r = node.r;
         this.c = node.c;
       }
}

class Heap {

    public static void minHeapify(HeapNode arr[], int i, int n) 
    {
        int l = i*2 + 1;
        int r = i*2 + 2;
        int smallest = i;
        
        if (l < n && arr[l].data < arr[i].data)
            smallest = l;
    
        if (r < n && arr[r].data < arr[smallest].data)
            smallest = r;
        
        if (smallest != i ) 
        {
            HeapNode tmp = new HeapNode(arr[i]);
            arr[i] = new HeapNode(arr[smallest]);
            arr[smallest] = new HeapNode(tmp);
            minHeapify(arr, smallest,n);
        }
    }

    public static void buildHeap(HeapNode[] arr, int n) 
    {
        int i = (n -1)/2;
        while (i >= 0) 
        {
            minHeapify(arr, i, n);
            i--;
        }
    }

    public static int kthSmallest(int[][] mat, int n,int k) 
    {
        // k must be greater than 0 and smaller than n*n 
        if (k <= 0 || k > n*n) 
        {
            return Integer.MAX_VALUE;
        }
        // Create a min heap of elements from first row of 2D array 
        HeapNode[] nodeArr = new HeapNode[n];
        for (int i = 0; i < n; i++) 
        {
            nodeArr[i] = new HeapNode();
            nodeArr[i].data = mat[0][i];
            nodeArr[i].r = 0;
            nodeArr[i].c = i;
        }
        buildHeap(nodeArr, n);

        HeapNode hr = new HeapNode();
        
        for (int i = 0; i < k; i++) 
        {
            // Get current heap root 
            hr = new HeapNode(nodeArr[0]);

            // Get next value from column of root's value. If the 
            // value stored at root was last value in its column, 
            // then assign INFINITE as next value
            
            int nextVal = (hr.r < (n - 1) ? mat[hr.r+1][hr.c]: Integer.MAX_VALUE);

            // Update heap root with next value 
             nodeArr[0].data = nextVal;
             nodeArr[0].r = hr.r+1;
             nodeArr[0].c = hr.c ;
            // Heapify root
            minHeapify(nodeArr, 0, n);
        }
        // Return the value at last extracted root
        return hr.data;
    }


   public static void main(String args[])
    {
    
        int mat[][] ={  {10, 20, 33, 40},
                        {22, 23, 35, 45},
                        {24, 29, 37, 48},
                        {32, 33, 39, 50},
                     };

        int k = 16;
        int res = kthSmallest(mat, 4, k);
        System.out.println(k +"th smallest element is: " + res);
    }


}

