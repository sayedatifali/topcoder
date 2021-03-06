import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BenfordsLaw
{
	public int questionableDigit(int[] transactions, int threshold)
	{
		int [] actualFreq = new int[9];
		double expFreq [] = new double[9];
		int firstDigit;
		
		for (int i = 1; i < 10; i++) {
			expFreq[i - 1] = transactions.length * getExpFreq(i);
		}
		
		for (int i : transactions) {
			firstDigit = getFirstDigit(i);
			actualFreq[firstDigit - 1]++;
		}
		
		for (int i = 0; i < 9; i++) {
			System.out.println("Expected = " + expFreq[i] + "\nActual = " + actualFreq[i]);
			if (actualFreq[i] > threshold * expFreq[i] || actualFreq[i] < (expFreq[i]/threshold))
				return i + 1;
//			if (expFreq[i] * threshold < actualFreq[i] || (expFreq[i] / threshold) < actualFreq[i])
		}
		
		return -1;
	}
	
	public double getExpFreq(double x) {
		x = 1/x;
		x = Math.log10(1 + x);
		return x;
	}
	
	public int getFirstDigit(int number) {
		while (number > 9) {
			number /= 10;
		}
		return number;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		BenfordsLaw obj;
		int answer;
		obj = new BenfordsLaw();
		long startTime = System.currentTimeMillis();
		answer = obj.questionableDigit(p0, p1);
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
		
		int[] p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{5236,7290,200,1907,3336,9182,17,4209,8746,7932,6375,909,2189,3977,2389,2500,1239,3448,6380,4812};
		p1 = 2;
		p2 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,10,100,2,20,200,2000,3,30,300};
		p1 = 2;
		p2 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{9,87,765,6543,54321,43219,321987,21987,1987,345,234,123};
		p1 = 2;
		p2 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,2,3,4,5,6,7,8,7,6,5,4,3,2,1};
		p1 = 8;
		p2 = 9;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{987,234,1234,234873487,876,234562,17,7575734,5555,4210,678234,3999,8123};
		p1 = 3;
		p2 = 8;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
