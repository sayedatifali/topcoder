import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RobotHerbDiv2
{

	public static int [] dx = new int[] {0, 1, 0, -1};
	public static int [] dy = new int[] {1, 0, -1, 0};
	
	public int getdist(int T, int[] a)
	{
		int i, j, N;
		int x2, y2;
		int index = 0;
		
		x2 = 0;
		y2 = 0;
		N = a.length;
		
		for (i = 0; i < T; i++) {
		
			for (j = 0; j < N; j++) {
			
				x2 = x2 + a[j] * dx[index];
				y2 = y2 + a[j] * dy[index];				
				
				index = (index + a[j]) % 4;
			
			}		
		
		}
		
		return Math.abs(x2) + Math.abs(y2);
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		RobotHerbDiv2 obj;
		int answer;
		obj = new RobotHerbDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getdist(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int p2;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = new int[]{1,2,3};
		p2 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 100;
		p1 = new int[]{1};
		p2 = 0;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 5;
		p1 = new int[]{1,1,2};
		p2 = 10;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 100;
		p1 = new int[]{400000};
		p2 = 40000000;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
