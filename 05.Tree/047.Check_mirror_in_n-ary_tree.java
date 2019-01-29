import java.io.*;
import java.util.*;
class BinaryTree
 {
	public static void main (String[] args)
	 {
	 
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        
	        int n=sc.nextInt(), e=sc.nextInt();
	        
	        HashMap<Integer,ArrayList<Integer>> m1=new HashMap<>();
	        HashMap<Integer,ArrayList<Integer>> m2=new HashMap<>();
	        
	        for(int i=0;i<e;i++){
	            int u=sc.nextInt(),v=sc.nextInt();
	            if(!m1.containsKey(u)){
	                ArrayList<Integer> l=new ArrayList<>();
	                l.add(v);
	                m1.put(u,l);
	            }else
	                m1.get(u).add(v);
	        }
	        
	        
	        for(int i=0;i<e;i++){
	            int u=sc.nextInt(),v=sc.nextInt();
	            if(!m2.containsKey(u)){
	                ArrayList<Integer> l=new ArrayList<>();
	                l.add(v);
	                m2.put(u,l);
	            }else
	                m2.get(u).add(v);
	        }
	        
	        
	        boolean fl=true;
	        for(Map.Entry<Integer,ArrayList<Integer>> en:m1.entrySet()){
	            
	            boolean flag=true;
	            int u=en.getKey();
	            ArrayList<Integer> l1=en.getValue(), l2=m2.get(u);
	            for(int i=0,j=l2.size()-1;i<=j;i++,j--){
	                
	                if(l1.get(i)!=l2.get(j)){
	                    flag=false;
	                    break;
	                }
	                
	            }
	            
	            if(!flag){ 
	                 fl=false;
	                 break;
	            }
	        }
	        
	       if(fl)
	        System.out.println(1);
	       else
	        System.out.println(0);
	        
	    }
	 }
}
