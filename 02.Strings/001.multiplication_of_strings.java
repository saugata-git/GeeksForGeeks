public class KaratsubaMultiplication {
	
	public static long performeKaratsuba(long x, long y){
		if(x < 10 || y < 10) return x*y;
		// get the length of longest number
		int maxBase = (int) Math.max(Math.log10(x), Math.log10(y)) + 1;
		int halfMax = Math.round(maxBase/2);
		//int halfMax = (maxBase/2) + (maxBase%2); // also valid
    		long a = x / (int) Math.pow(10, halfMax);
		long b = x % (int) Math.pow(10, halfMax);
    		long c = y / (int) Math.pow(10, halfMax);
		long d = y % (int) Math.pow(10, halfMax);
		
		long ac = performeKaratsuba(a, c);
		long bd = performeKaratsuba(b, d);
		long abcd = performeKaratsuba((a+b), (c+d));
		abcd = abcd - ac - bd;
    
		return (long) ((ac*Math.pow(10, (2*halfMax))) + (abcd*Math.pow(10, halfMax)) + bd);
	}
}
