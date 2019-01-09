class QNode{

    int key;
    QNode next;
    public QNode(int key){
     this.key=key;
     this.next=null;
    }

}

class Queue{

   QNode front,rear;
   public Queue(){
       this.front=this.rear=null;
   }
   void enqueue(int key){
      
     QNode temp=new QNode(key);
     if(this.rear==null){
      this.front=this.rear=temp;
       return;
     }
     this.rear.next=temp;
     this.rear=temp;

   }
   QNode dequeue(){
      if(this.front==null){
          return null;
      }
      QNode temp=this.front;
      this.front=this.front.next;
      
      if(this.front==null){
         this.rear=null;
      }
     return temp;
   }

   void printqueue(){
    QNode temp=front;
     System.out.println("Queue is:");
    while(temp!=null){
       
        System.out.print(temp.key+"->");
        
         temp=temp.next;
    }
     System.out.println();
   }
   public static void main(String args[]){
     Queue q= new Queue();
     q.enqueue(10);
     q.enqueue(20);
     q.enqueue(30);
     q.printqueue();
     System.out.println("Dequeued item is "+ q.dequeue().key); 
     q.printqueue();
   }
}
