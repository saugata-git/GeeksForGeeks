//Program to generate all possible valid IP addresses from given string

import java.util.*;
class ipadd{

   public static ArrayList<String> genIp(String s){

     ArrayList<String> result= new ArrayList<>();
     if(s.length()<4 ||s.length()>13)
        return result;

     for(int i=1;i<4;i++){
          for(int j=1;j<4;j++){
             for(int k=1;k<4;k++){

                if(i+j+k>s.length()-1)continue;
                if(s.length()-(i+j+k)>3)continue;

                int a = Integer.parseInt(s.substring(0, i));
	              int b = Integer.parseInt(s.substring(i, i+j));
	              int c = Integer.parseInt(s.substring(i+j, i+j+k));
		            int d = Integer.parseInt(s.substring(i+j+k));

                if ((""+a+b+c+d).length()!=s.length()) continue;

	            if (a<256&&b<256&&c<256&&d<256){
		             result.add(""+a+"."+b+"."+c+"."+d);
	             }
             }
          }
     }
    
    return result;
   }

   public static void main(String args[]){
         System.out.println(genIp("25525511135")); 
   }
}
