import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class NoRepeatPlaylist
{
	public static int sMod = 1000000007;
	
	public int numPlaylists(int N, int M, int P)
	{
		int i;
		int j;
		int k;
		long mem[][][];
		int ans;		
		
		mem = new long[P + 1][N + 1][N + 1];
		
		for (i = 0; i < P + 1; i++) {
			for (j = 0; j < N + 1; j++) {
				for (k = 0; k < N + 1; k++) {
					mem[i][j][k] = -1;
				}
			}
		}
		
		ans = (int) (numPossible(0, N, M, P, mem) % sMod);
		
		return ans;
		
	}
	
	
	public long numPossible(int X, int Y, int M, int P, long [][][] mem) {
	
		long count = 0;		
		
		if (P == 0 && Y == 0)
			return 1;
		
		if (P == 0)
			return 0;
			
		if (mem[P][X][Y] != -1)
			return mem[P][X][Y];
		
		if (Y > 0) {
			count += ((numPossible(X + 1, Y - 1, M, P - 1, mem) * Y) % sMod);
		}
		
		if (X > M) {		
			count += ((numPossible(X, Y, M, P - 1, mem) * (X - M)) % sMod);
		}
		
		mem[P][X][Y] = count % sMod;
		
//		System.out.println("Returning count = " + count);
		
		return mem[P][X][Y];
	
	}
	
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		NoRepeatPlaylist obj;
		int answer;
		obj = new NoRepeatPlaylist();
		long startTime = System.currentTimeMillis();
		answer = obj.numPlaylists(p0, p1, p2);
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
		p0 = 1;
		p1 = 0;
		p2 = 3;
		p3 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 1;
		p1 = 1;
		p2 = 3;
		p3 = 0;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 2;
		p1 = 0;
		p2 = 3;
		p3 = 6;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 4;
		p1 = 0;
		p2 = 4;
		p3 = 24;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 2;
		p1 = 1;
		p2 = 4;
		p3 = 2;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 50;
		p1 = 5;
		p2 = 100;
		p3 = 222288991;
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
