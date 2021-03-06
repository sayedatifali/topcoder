import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BigFatInteger2
{

	public static HashMap<Integer, Integer> sNum;
	public static HashMap<Integer, Integer> sDenom;

	public String isDivisible(int A, int B, int C, int D)
	{		
		int i;
		int j;
		int key;
		int val;
		int val2;
		
		long x;
		long y;
		
		sNum  = new HashMap<Integer, Integer>();
		sDenom  = new HashMap<Integer, Integer>();
		
		
		allDivisorsNum(A);
		allDivisorsDenom(C);
  //      System.out.println("sNum size = " + sNum.size());
   //     System.out.println("sDenom size = " + sDenom.size());
		
		Iterator it = sDenom.entrySet().iterator();
    	
    	while (it.hasNext()) {
        	Map.Entry pairs = (Map.Entry)it.next();
  //      	System.out.println(pairs.getKey() + " = " + pairs.getValue());
        	
        	key = (int) pairs.getKey();
        	val2 = (int) pairs.getValue();
        	
        	if (!sNum.containsKey(key))
        		return "not divisible";
        	
        	val = sNum.get(key);
        	
        	x = 1L * val * B;
        	y = 1L * val2 * D;
        	
        	if (x < y)
        		return "not divisible";
        		
        	it.remove();
        	
        	
        	//it.remove(); // avoids a ConcurrentModificationException
        }
        
  //      System.out.println("sNum size = " + sNum.size());
   //     System.out.println("sDenom size = " + sDenom.size());
        
        if (sDenom.size() != 0)
        	return "not divisible";
		
		return "divisible";
	}
	
	public boolean isPrime(int num) {
		int i;
		int N;
		
		N = (int) Math.sqrt(num);
		
		if (num == 1)
			return false;
		
		if (num == 2)
			return true;
		
		for (i = 2; i <= N; i++) {
		
			if (num % i == 0)
				return false;
		
		}
		
		return true;
	
	}
	
	
	public void allDivisorsNum(int num) {
	
		int i;
		int limit;
		int temp;
		
		limit = num / 2;
		
		if (isPrime(num)) {
			sNum.put(num, 1);
			return;
		}
		
		for (i = 2; i <= limit; i++) {
		
			if (num % i == 0)
				sNum.put(i, 0);
				
			while (num % i == 0) {
			
				num = num / i;
				
				temp = sNum.get(i);
				
				sNum.put(i, temp + 1);				
			
			}
			
			limit = num + 1;
		
		}
	
	}
	
	public void allDivisorsDenom(int num) {
	
		int i;
		int limit;
		int temp;
		
		limit = num / 2;
		
		if (isPrime(num)) {
			sDenom.put(num, 1);
			return;
		}
		
		
		for (i = 2; i <= limit; i++) {
		
			if (num % i == 0)
				sDenom.put(i, 0);
				
			while (num % i == 0) {
			
				num = num / i;
				
				temp = sDenom.get(i);
				
				sDenom.put(i, temp + 1);				
			
			}
			
			limit = num + 1;
		
		}
	
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, String p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		BigFatInteger2 obj;
		String answer;
		obj = new BigFatInteger2();
		long startTime = System.currentTimeMillis();
		answer = obj.isDivisible(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p4 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p4);
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		int p0;
		int p1;
		int p2;
		int p3;
		String p4;
		
		// ----- test 0 -----
		p0 = 6;
		p1 = 1;
		p2 = 2;
		p3 = 1;
		p4 = "divisible";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 1;
		p2 = 6;
		p3 = 1;
		p4 = "not divisible";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 1000000000;
		p1 = 1000000000;
		p2 = 1000000000;
		p3 = 200000000;
		p4 = "divisible";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 8;
		p1 = 100;
		p2 = 4;
		p3 = 200;
		p4 = "not divisible";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 999999937;
		p1 = 1000000000;
		p2 = 999999929;
		p3 = 1;
		p4 = "not divisible";
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 2;
		p1 = 2;
		p2 = 4;
		p3 = 1;
		p4 = "divisible";
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
