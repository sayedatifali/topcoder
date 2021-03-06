import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CountExpressions
{
	public static int sCount = 0;
	public static int sX;
	public static int sY;
	public static int sVal;
	
	public int calcExpressions(int x, int y, int val)
	{
		sX = x;
		sY = y;
		sVal = val;
		
		sCount = 0;
		validCount(0, 0, 0);
		
		return sCount;
	}
	
	
	public void validCount(int xCount, int yCount, int sum) {
	
		int i;
		int j;
		int ans;
		
		if (xCount == 2 && yCount == 2) {
			if (sum == sVal)
				sCount++;
			return;
		}
		
		if (xCount == 0 && yCount == 0) {
			
			validCount(xCount + 1, yCount, sX);
			validCount(xCount, yCount + 1, sY);
			
			return;
		
		}
		
		if (xCount != 2) {
			validCount(xCount + 1, yCount, sX + sum);
			validCount(xCount + 1, yCount, sum - sX);
			validCount(xCount + 1, yCount, sum * sX);
		}
		
		if (yCount != 2) {
			validCount(xCount, yCount + 1, sY + sum);
			validCount(xCount, yCount + 1, sum - sY);
			validCount(xCount, yCount + 1, sum * sY);			
		}	
	
	}
	
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		CountExpressions obj;
		int answer;
		obj = new CountExpressions();
		long startTime = System.currentTimeMillis();
		answer = obj.calcExpressions(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		
		// ----- test 0 -----
		p0 = 7;
		p1 = 8;
		p2 = 16;
		p3 = 9;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 3;
		p1 = 5;
		p2 = 7;
		p3 = 5;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 99;
		p1 = 100;
		p2 = 98010000;
		p3 = 6;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = -99;
		p1 = 42;
		p2 = -1764;
		p3 = 2;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 100;
		p1 = -100;
		p2 = -100000000;
		p3 = 0;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 1;
		p1 = 2;
		p2 = 5;
		p3 = 17;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
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
