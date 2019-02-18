//Time Complexity: O(i*(i+1)/2) or O(i^2)
//Auxiliary Space: O(i*(i+1)/2) or O(i^2)
 
class dp{

  static float findWater(int i,int j,float X){
    
    if(j>i){
      System.out.println("Incorrect Input");
      System.exit(0);
    }
   int ll=Math.round(i*(i+1));
   float[] glass =new float[ll+2];
   int index=0;
   glass[index]=X;
   for(int row=1;row<=i;row++){
      for(int col=1;col<=row;++col,++index){
        X=glass[index];
        glass[index]=(X>=1.0f)?1.0f:X;
        X=(X>=1.0f)?(X-1):0.0f;

       glass[index +row]+=X/2;
       glass[index+row+1]+=X/2;
      }
   }
   return glass[(int)(i*(i-1)/2 +j-1)];
  }

  public static void main(String[] args){ 
    int i = 2, j = 2; 
    float X = 2.0f; 
    System.out.println("Amount of water in jth " + "glass of ith row is: " +  findWater(i, j, X)); 
  } 

}
