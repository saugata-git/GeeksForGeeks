public class ReverseWords{

  public static void main(String args[]){
   String s="i like this program very much";
   String str[]=s.split(" ");
   String ans="";
   for(int i=str.length-1;i>=0;i--){
      ans+=str[i]+" ";
   }
   System.out.println("Reversed String:"); 
   System.out.println(ans.substring(0,ans.length()-1));
  }
}
