import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class TheCowDivTwo {
	public static int sMod = 1000000007;

	public int find(int N, int K) {
		return (int) dpFind(N, K);
	}

	public long dpFind(int N, int K) {

		int i, j, k, p;
		int dp[][][];

		dp = new int[2][K + 1][N]; // N, K, sum

		for (p = N; p >= 0; p--) {
			i = p % 2;
			for (j = 0; j <= K; j++) {
				for (k = 0; k < N; k++) {
					
					if (j == 0) {
						if (k == 0)
							dp[i][j][k] = 1;
						else
							dp[i][j][k] = 0;
					} else {

						if (i == N)
							dp[i][j][k] = 0;
						else
							dp[i][j][k] = (dp[(i + 1) % 2][j - 1][(k + p) % N] + dp[(i + 1) % 2][j][k])
									% sMod;
					}
				}
			}
		}

		return dp[0][K][0] % sMod;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1,
			boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		TheCowDivTwo obj;
		int answer;
		obj = new TheCowDivTwo();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0
				+ " seconds");
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
		int p1;
		int p2;

		// ----- test 0 -----
		p0 = 7;
		p1 = 4;
		p2 = 5;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 1;
		p1 = 1;
		p2 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 58;
		p1 = 4;
		p2 = 7322;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 502;
		p1 = 7;
		p2 = 704466492;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 1000;
		p1 = 47;
		p2 = 219736903;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		if (all_right) {
			System.out
					.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!