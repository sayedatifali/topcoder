import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TheLotteryBothDivs
{
	public double find(String[] goodSuffixes)
	{
		int numbers;
		int suffixLen[];
		int suffix[];
		int len;
		int i, j;
		int max;
		double prob;
		double probUnit;
		int total = 0;
		
		prob = 0;
		max = 1000000000; // 10 ^ 9
		probUnit = 1 / max;
		
		
		numbers = 0;
		len = goodSuffixes.length;
		suffixLen = new int[len];
		suffix = new int[len];
		
//		Arrays.sort(goodSuffixes);
		
		for (i = 0; i < len; i++) {
			suffixLen[i] = (int) Math.pow(10, goodSuffixes[i].length());
			suffix[i] = Integer.valueOf(goodSuffixes[i]);
			System.out.println(goodSuffixes[i]);
		}
		
		for (i = 0; i < len; i++) {
		
			for (j = 0; j < len; j++) {
			
			if (suffixLen[j] == max + 1)
				continue;
			
			//	if (goodSuffixes[j].indexOf(goodSuffixes[i], goodSuffixes[j].length() - goodSuffixes[i].length()) != -1) {
			if (goodSuffixes[i].length() < goodSuffixes[j].length() || i == j)
				continue;
			
			if (goodSuffixes[i].endsWith(goodSuffixes[j])) {
				
//					System.out.println(
				
					suffixLen[i] = max + 1;
				
				}
			
			}
		
		}
		
		
		
		for (i = 0; i < len; i++) {
		
			total += max / suffixLen[i];
			prob = total * 1.0 / (1.0 * max);		
			System.out.println("Number = " + goodSuffixes[i] + "; suffixLen = " + suffixLen[i] + "; prob temp = " + prob);
					
		}
		
		prob = total * 1.0 / (1.0 * max);
		
		return prob;
		
	}
		// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, double p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		TheLotteryBothDivs obj;
		double answer;
		obj = new TheLotteryBothDivs();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0);
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
			res = Math.abs(p1 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p1));
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
		
		String[] p0;
		double p1;
		
		// ----- test 0 -----
		p0 = new String[]{"4"};
		p1 = 0.1D;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"4","7"};
		p1 = 0.2D;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"47","47"};
		p1 = 0.01D;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"47","58","4747","502"};
		p1 = 0.021D;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"8542861","1954","6","523","000000000","5426","8"};
		p1 = 0.201100101D;
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
