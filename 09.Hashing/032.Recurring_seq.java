import java.util.*;

class RecurringSeq{

   static String fractionToDecimal(int numerator,int denominator){
       if(numerator==0)
           return "0";
       if(denominator==0)
           return "";
       String result="";

       // is result is negative
       if((numerator<0)^(denominator<0)){
            result+="-";
       }

      //convert int to long
      long num=numerator,den=denominator;
      num=Math.abs(num);
      den=Math.abs(den);

      //quotient
      long res=num/den;
      result+=String.valueOf(res);
      
      // if remainder is 0, return result
      long  remainder=(num % den)*10;
      if(remainder == 0)
        return result;

      // right-hand side of decimal point
      HashMap<Long,Integer> map =new HashMap<Long,Integer>();
      result+=".";
      while(remainder!=0){

                  if(map.containsKey(remainder)){
                      int beg=map.get(remainder);
                      String part1=result.substring(0,beg);
                      String part2=result.substring(beg,result.length());
                      result=part1+"("+part2+")";
                      return result;
                  }

                  map.put(remainder,result.length());
                  res=remainder/den;
                  result+=String.valueOf(res);
                  remainder=(remainder % den)*10;
      }
      return result;
        
   }
    
   public static void main(String args[]){
      int numerator=50;
      int denominator=22;
      String res= fractionToDecimal(numerator,denominator);
      if(res=="")
         System.out.println("No recurring Number");
      else
         System.out.println("Number with recurring seq in braces is --> "+ res);
   }
}
