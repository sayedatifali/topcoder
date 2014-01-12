import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class NumberofFiboCalls
{
	public int[] fiboCallsMade(int n)
	{
		int i;
		int j;
		int dpZero[];
		int dpOnes[];
		
		
		dpZero = new int[n + 1];
		dpOnes = new int[n + 1];
		
		if (n == 0)
			return new int[] {1, 0};
		
		dpZero[0] = 1;
		dpOnes[0] = 0;
		dpZero[1] = 0;
		dpOnes[1] = 1;
		
		for(i = 2; i <= n; i++) {
		
			dpOnes[i] = dpOnes[i - 1] + dpOnes[i - 2];
			dpZero[i] = dpZero[i - 1] + dpZero[i - 2];		
		
		}
		
		return new int[]{dpZero[n], dpOnes[n]};
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		NumberofFiboCalls obj;
		int[] answer;
		obj = new NumberofFiboCalls();
		long startTime = System.currentTimeMillis();
		answer = obj.fiboCallsMade(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p1.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p1[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p1[i]) {
						res = false;
					}
				}
			}
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
		int[] p1;
		
		// ----- test 0 -----
		p0 = 0;
		p1 = new int[]{1,0};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 3;
		p1 = new int[]{1,2};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 6;
		p1 = new int[]{5,8};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 22;
		p1 = new int[]{10946,17711};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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