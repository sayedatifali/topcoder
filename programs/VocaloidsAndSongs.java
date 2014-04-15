import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

// Solving using Inclusion/Exclusion Principle
public class VocaloidsAndSongs
{
	public static final long MOD = 1000000007;
	
	public int count(int S, int gumi, int ia, int mayu)
	{
		int i;
		long ans;
		long temp;
		BigInteger mul;
		
		ans = 0;
		
		for (i = 0; i <= S; i++) {
		
			temp = nCr(S, i) % MOD;
			temp = (temp % MOD * nCr(S - i, gumi) % MOD) % MOD;
			temp = (temp % MOD * nCr(S - i, ia) % MOD) % MOD;
			temp = (temp % MOD * nCr(S - i, mayu) % MOD) % MOD;
		
	//		System.out.println(temp);
			
			if (i % 2 == 0)
				ans = (ans + temp) % MOD;
			else {
				if (temp > ans)
					ans += MOD;
				ans = (ans - temp) % MOD;
			}
		
		//	System.out.println(ans);
		}
		
		ans = ans % MOD;
		
		return (int) ans;
	}
	

	public long nCr(long n, long r) {
	
		long ans = 1;
		
		if (r > n)
			return 0;
		
		for (long i = 1; i <= r; i++) {
			ans = ans * (n - i + 1) / i;
		}
		
		return ans % MOD;
	
	}
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		VocaloidsAndSongs obj;
		int answer;
		obj = new VocaloidsAndSongs();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0, p1, p2, p3);
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
			res = answer == p4;
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
		
		// ----- test 0 -----
		p0 = 3;
		p1 = 1;
		p2 = 1;
		p3 = 1;
		p4 = 6;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 3;
		p1 = 3;
		p2 = 1;
		p3 = 1;
		p4 = 9;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 50;
		p1 = 10;
		p2 = 10;
		p3 = 10;
		p4 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 18;
		p1 = 12;
		p2 = 8;
		p3 = 9;
		p4 = 81451692;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 50;
		p1 = 25;
		p2 = 25;
		p3 = 25;
		p4 = 198591037;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
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
