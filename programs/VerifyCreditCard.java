import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class VerifyCreditCard
{
	public String checkDigits(String cardNumber)
	{
		int i;
		int dig;
		int len;
		int count = 0;
		
		len = cardNumber.length();
		
		if (len % 2 == 0) {
		
			for (i = 0; i < len; i++) {
			
				dig = Integer.valueOf(cardNumber.charAt(i) - '0');
				
				System.out.println(dig);
				
				if (i % 2  == 0)
					dig *= 2;
					
				if (dig > 9) {
				
					while (dig != 0) {
					
						count += (dig % 10);
						dig /= 10;
					}				
				
				} else 				
					count += dig;
			
			}
		
		}
		
		else {
		
			for (i = 0; i < len; i++) {
			
				dig = Integer.valueOf(cardNumber.charAt(i) - '0');
				
				if (i % 2  != 0)
					dig *= 2;
					
				if (dig > 9) {
				
					while (dig != 0) {
					
						count += (dig % 10);
						dig /= 10;
					}				
				
				} else
					count += dig;
			
			}	
		
		
		}
		
		if (count % 10 == 0)
			return "VALID";
		
		
		return "INVALID";
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		VerifyCreditCard obj;
		String answer;
		obj = new VerifyCreditCard();
		long startTime = System.currentTimeMillis();
		answer = obj.checkDigits(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		
		String p0;
		String p1;
		
		// ----- test 0 -----
		p0 = "21378";
		p1 = "VALID";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "31378";
		p1 = "INVALID";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "11111101";
		p1 = "VALID";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "50005";
		p1 = "VALID";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "542987223412";
		p1 = "INVALID";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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