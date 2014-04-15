import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RandomOption
{
	public int N;
	public boolean banned[][];
	public double mem[][];
	
	public double getProbability(int keyCount, int[] badLane1, int[] badLane2)
	{
		int i;
		int badCount;
		
		badCount = badLane1.length;
		banned = new boolean[keyCount][keyCount];
		
		for (i = 0; i < badCount; i++) {
		
			banned[badLane1[i]][badLane2[i]] = true;
			banned[badLane2[i]][badLane1[i]] = true;
		
		}
		
		N = keyCount;
		mem = new double[1 << N][N];
		
		memInit();
		
		return rec(0, -1);		
		
	}
	
	public void memInit() {
		
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				mem[i][j] = -1;
			}
		}
	
	}
	
	public double rec(int mask, int last) {
	
		int i;
		int t;
		int newMask;
		double prob;
		
		prob = 0.0;
		t = 0;
		
		if (mask == ((1 << (N + 1)) - 1))
			return 1;

//		System.out.println("last = " + last + "; mask = " + mask);
		
		if (last >= 0 && mem[mask][last] != -1) {
	//		System.out.println("Memoization, Yeah!");
			return mem[mask][last];
		}
		
		for (i = 0; i < N; i++) {
		
			if ((mask & (1 << i)) > 0)
				continue;
				
			if (isBanned(i, last)) {
				t++;
				continue;
			}
				
			newMask = (mask | (1 << i));
			
			prob += rec(newMask, i);
			
			t++;
		
		}
		
		if (t != 0)
			prob = prob / (1.0 * t);
		else
			prob = 1;
		
		if (last >= 0)
			mem[mask][last] = prob;
		
		return prob;
	
	}
	
	public boolean isBanned(int a, int b) {
	
		if (a < 0 || b < 0 || a >= N || b >= N)
			return false;
		
		return (banned[a][b] || banned[b][a]);
	
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, int[] p2, boolean hasAnswer, double p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		RandomOption obj;
		double answer;
		obj = new RandomOption();
		long startTime = System.currentTimeMillis();
		answer = obj.getProbability(p0, p1, p2);
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
			res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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
		int[] p2;
		double p3;
		
		// ----- test 0 -----
		p0 = 5;
		p1 = new int[]{0};
		p2 = new int[]{3};
		p3 = 0.6D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 5;
		p1 = new int[]{0,1,2};
		p2 = new int[]{1,2,0};
		p3 = 0.1D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 5;
		p1 = new int[]{2,2,2,2};
		p2 = new int[]{0,1,3,4};
		p3 = 0.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 7;
		p1 = new int[]{0,1,2};
		p2 = new int[]{6,5,4};
		p3 = 0.3904761904761904D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 7;
		p1 = new int[]{3,5,1,0,2,6,4};
		p2 = new int[]{0,2,4,6,1,5,3};
		p3 = 0.09166666666666667D;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
