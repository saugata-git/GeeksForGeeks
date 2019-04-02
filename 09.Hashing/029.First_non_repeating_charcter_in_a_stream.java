import java.util.ArrayList;
import java.util.List;

public class NonReapeatingChar{
  
   final static int MAX_CHAR=256;
   
   static void findFirstNonRepeating(String stream){
   
       List<Character> list =new ArrayList<Character>();
       boolean[] repeated =new boolean[MAX_CHAR];
       
       
       for(int i=0;i<stream.length();i++){
          char x=stream.charAt(i);
          System.out.println("Reading "+ x +" from stream n");
          
          if(!repeated[x]){
          
              if(!(list.contains(x))){
                list.add(x);
              }
              else{
                  list.remove((Character)x);
                  repeated[x]=true;
              }
          }
          
          if(list.size()!=0){
                System.out.print("First non-repeating character so far is "); 
                System.out.println(list.get(0)); 
          }
       }
       
   }

   public static void main(String args[]){
   
      String stream = "geeksforgeeksandgeeksquizfor"; 
      findFirstNonRepeating(stream); 
   } 
   
}
