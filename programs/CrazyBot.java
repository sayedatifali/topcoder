import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CrazyBot
{
	public static boolean visit[][];
	public int N;
	public double east;
	public double west;
	public double south;
	public double north;
//	public double prob;
	
	public double getProbability(int n, int east, int west, int south, int north)
	{
		double ans;
		
		visit = new boolean[2 * n + 1][2 * n + 1];
		this.east = east * 1.0 / 100;
		this.west = west * 1.0 / 100;
		this.south = south * 1.0 / 100;
		this.north = north * 1.0 / 100;
		N = n;
		
		ans = prob(n, 0, 0);
		
		return ans;
		
	}
	
	public double prob(int n, int x, int y) {
	
		double prob = 0;
			
		if (visit[N + x][N + y])
			return 0;
		
		if (n == 0)
			return 1;
			
		visit[N + x][N + y] = true;
		
		prob += north * prob(n - 1, x, y - 1); // North
		prob += south * prob(n - 1, x, y + 1); // South
		prob += west * prob(n - 1, x - 1, y); // West
		prob += east * prob(n - 1, x + 1, y); // East
		
		visit[N + x][N + y] = false;
		
		return prob;
	}
	
	
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, int p4, boolean hasAnswer, double p5) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + p4);
		System.out.println("]");
		CrazyBot obj;
		double answer;
		obj = new CrazyBot();
		long startTime = System.currentTimeMillis();
		answer = obj.getProbability(p0, p1, p2, p3, p4);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p5);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = Math.abs(p5 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p5));
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
		int p4;
		double p5;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 25;
		p2 = 25;
		p3 = 25;
		p4 = 25;
		p5 = 1.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 25;
		p2 = 25;
		p3 = 25;
		p4 = 25;
		p5 = 0.75D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 7;
		p1 = 50;
		p2 = 0;
		p3 = 0;
		p4 = 50;
		p5 = 1.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 14;
		p1 = 50;
		p2 = 50;
		p3 = 0;
		p4 = 0;
		p5 = 1.220703125E-4D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 14;
		p1 = 25;
		p2 = 25;
		p3 = 25;
		p4 = 25;
		p5 = 0.008845493197441101D;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, true, p5) && all_right;
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
