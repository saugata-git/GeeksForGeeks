/*
Time Complexity: O(n Log n)
Auxiliary Space : O(n)
Algorithm:

Create two heaps. One max heap to maintain elements of lower half and one min heap to maintain elements of higher 
half at any point of time..
Take initial value of median as 0.
For every newly read element, insert it into either max heap or min heap and calulate the median based on the 
following conditions:
If the size of max heap is greater than size of min heap and the element is less than previous median then pop the top 
element from max heap and insert into min heap and insert the new element to max heap else insert the new element to min heap.
Calculate the new median as average of top of elements of both max and min heap.

If the size of max heap is less than size of min heap and the element is greater than previous median then pop the top
element from min heap and insert into max heap and insert the new element to min heap else insert the new element to max heap.
Calculate the new median as average of top of elements of both max and min heap.

If the size of both heaps are same. Then check if current is less than previous median or not. If the current element is
less than previous median then insert it to max heap and new median will be equal to top element of max heap. If the current
element is greater than previous median then insert it to min heap and new median will be equal to top element of min heap.
*/

import java.util.*;

public class Median {

    public static  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
    public static  PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();

        medianTracker(array);
    }
    
    public static void medianTracker(int [] array) {

        for (int i = 0; i < array.length; i++) {
            addNumber(array[i]);
            System.out.println(getMedian());
        }
    }
    
    private static void addNumber(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        }

        else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } 
            else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } 

        else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            }
            else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
        
    }
    
    private static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } 
        else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { 
            return maxHeap.peek();
        }
    }
} 
