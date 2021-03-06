import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TorusSailingEasy
{
	private static boolean [][] marked;
	private static int N, M;
	private static double [][][] mem;
	private static int maxDays = 6200;
	
	public double expectedTime(int N, int M, int goalX, int goalY)
	{
		double expect = 0;
		
		marked = new boolean[N + 1][M + 1];
		
		this.N = N;
		this.M = M;
		
		mem = new double[N + 1][M + 1][maxDays + 1];
		
		for (int i = 0; i <= N; i++)
			for (int j = 0; j <= M; j++)
				for (int k = 0; k <= maxDays; k++)
					mem[i][j][k] = -1;
		
		expect = expDays(0, 0, goalX, goalY, 0);

		if (!marked[goalX][goalY])
			return -1;
		
		return expect;
	}
	
	public double expDays(int i, int j, int goalX, int goalY, int d) {
	
		double ans = 0;
		
		marked[i][j] = true;
		
		if (i == goalX && j == goalY) {
			return d;
		}
		
		if (d == maxDays)
			return 0;
			
		if (mem[i][j][d] >= 0)
			return mem[i][j][d];
	
		ans = expDays((i + 1) % N, (j + 1) % M, goalX, goalY, d + 1);
		
		ans += expDays((i + N - 1) % N, (j + M - 1) % M, goalX, goalY, d + 1);
		
		
		return (mem[i][j][d] = ans / 2);
	
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, double p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		TorusSailingEasy obj;
		double answer;
		obj = new TorusSailingEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.expectedTime(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = Math.abs(p4 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p4));
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
		double p4;
		
		// ----- test 0 -----
		p0 = 2;
		p1 = 2;
		p2 = 1;
		p3 = 1;
		p4 = 1.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 2;
		p2 = 0;
		p3 = 1;
		p4 = -1.0D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 3;
		p1 = 3;
		p2 = 1;
		p3 = 1;
		p4 = 2.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 4;
		p1 = 6;
		p2 = 1;
		p3 = 3;
		p4 = 27.0D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
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
