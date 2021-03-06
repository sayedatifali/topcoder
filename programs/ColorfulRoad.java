import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ColorfulRoad
{
	public int getMin(String road)
	{
		int i;
		int j;
		int l;
		int k;
		int N;
		int min;
		int dp[];
		char color[] = {'R', 'G', 'B'};
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		hashMap.put('R', 0);
		hashMap.put('G', 1);
		hashMap.put('B', 2);
		
		N = road.length();
		
	//	dp = new int[N][N];
		dp = new int[N];
		
	//	dp[0] = -1;	
		

		/*
		for (l = 2; l <= N; l++) {
		
			for (i = 0; i < N - l + 1; i++) {
			
				j = i + l - 1;
			
				for (k = i; k < j; k++) {
				
					
				
				}
			
			}
		
		
		}
		*/
		
		for (i = 1; i < N; i++) {
		
			min = Integer.MAX_VALUE;
			k = Integer.MAX_VALUE;
		
			for (j = 0; j < i; j++) {
			
				l = hashMap.get(road.charAt(j));
				l = (l + 1) % 3;
			
				if (color[l] == road.charAt(i) && dp[j] != -1)			
					k = dp[j] + (i - j) * (i - j);
				
				min = Math.min(min, k);
			
			}
			
			if (min == Integer.MAX_VALUE)
				dp[i] = -1;
			else
				dp[i] = min;
		
		}
		
		
		
		return dp[N - 1];
		
		
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		ColorfulRoad obj;
		int answer;
		obj = new ColorfulRoad();
		long startTime = System.currentTimeMillis();
		answer = obj.getMin(p0);
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
		p0 = "RGGGB";
		p1 = 8;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "RGBRGBRGB";
		p1 = 8;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "RBBGGGRR";
		p1 = -1;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "RBRRBGGGBBBBR";
		p1 = 50;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "RG";
		p1 = 1;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "RBRGBGBGGBGRGGG";
		p1 = 52;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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
