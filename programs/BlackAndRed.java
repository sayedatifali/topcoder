import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BlackAndRed
{
	public int cut(String deck)
	{
		String temp;
		int cutPoint;
		int i;
		int N;
		int j;
		int red;
		int black;
		boolean ans = false;
		
		N = deck.length();
		
		
		for (i = 0; i <= N; i++) {
			red = 0;
			black = 0;
			cutPoint = i;
			ans = true;
			temp = deck.substring(cutPoint, N) + deck.substring(0, cutPoint);
			
			for (j = 0; j < N; j++) {
			
				if(temp.charAt(j) == 'B')
					black++;
				else
					red++;
				
				if (red > black) {
					ans = false;
					break;
				}
			
			}
			
			if (ans)
				return cutPoint;
		
		}
		
		return 0;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		BlackAndRed obj;
		int answer;
		obj = new BlackAndRed();
		long startTime = System.currentTimeMillis();
		answer = obj.cut(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		int p1;
		
		// ----- test 0 -----
		p0 = "BRBRBR";
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "RBRBRB";
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "BBBRRRRB";
		p1 = 7;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "BR";
		p1 = 0;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "RBRBBRRRRBBBRBBRRBRBBRRRBRBBBRBRBRBRBRRB";
		p1 = 9;
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