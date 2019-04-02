import java.util.*;

public class NutsAndBoults{

    static  void nutboltsmatch(char nuts[],char bolts[],int n){
     
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

        for(int i=0;i<n;i++){
            hm.put(nuts[i],i);
        }
        for(int i=0;i<n;i++){
           if(hm.containsKey(bolts[i])){
              nuts[i]=bolts[i];
           }
        }
        System.out.println("Matched nuts and boults are-");
        for(int i=0;i<n;i++){
            System.out.print(nuts[i]+" ");                       
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(bolts[i]+" ");
        }
    }

    public  static void main(String args[]){

        char nuts[] = {'@', '#', '$', '%', '^', '&'}; 
        char bolts[] = {'$', '%', '&', '^', '@', '#'}; 
        int n= nuts.length;
        nutboltsmatch(nuts,bolts,n);
     
    }
}
