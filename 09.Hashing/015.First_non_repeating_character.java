/*
//Given a string, find its first non-repeating character
//The above approach takes O(n) time
*/
import java.util.HashMap;
class CountIndex{

   int count,index;
   public CountIndex(int index){
     this.count=1;
     this.index=index;
   }

   public void incCount(){
    this.count++;
   }
}

class FirstNonRepeating{

    static final int NO_OF_CHARS=256;
    static HashMap<Character,CountIndex> hm= new HashMap<Character,CountIndex>();
    
    static void getCharCountArray(String str){

      for(int i=0;i<str.length();i++){
          if(hm.containsKey(str.charAt(i))){
             hm.get(str.charAt(i)).incCount();
          }
          else{
             hm.put(str.charAt(i),new CountIndex(i));
          }
      }      
    }

    static int firstNonRepeating(String str){
       getCharCountArray(str);
       int result=Integer.MAX_VALUE,i;

       for(i=0;i<str.length();i++){
           if (hm.get(str.charAt(i)).count == 1 && result > hm.get(str.charAt(i)).index){ 
                 result = hm.get(str.charAt(i)).index; 
            } 
       }
      return result;
    }

    public static void main (String[] args){ 
        String str = "geeksforgeeks"; 
        int index =  firstNonRepeating(str); 
          
        System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating " + " or string is empty" : "First non-repeating character is " +  str.charAt(index)); 
     } 

}

/*
  static final int NO_OF_CHARS = 256; 
    static char count[] = new char[NO_OF_CHARS]; 
      
    /* calculate count of characters  
      // in the passed string 
     static void getCharCountArray(String str)  
     { 
         for (int i = 0; i < str.length();  i++) 
              count[str.charAt(i)]++; 
     } 
       
    /* The method returns index of first non-repeating 
       character in a string. If all characters are repeating  
       then returns -1 */


 /*   static int firstNonRepeating(String str) 
    { 
        getCharCountArray(str); 
        int index = -1, i; 
       
        for (i = 0; i < str.length();  i++) 
        { 
            if (count[str.charAt(i)] == 1) 
            { 
                index = i; 
                break; 
            }    
        }   
        
      return index; 
    } 
  
*/
