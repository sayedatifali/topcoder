import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BinPackingEasy
{
	public int minBins(int[] item)
	{
		boolean marked[];
		int i;
		int j;
		int N;
		int minBins = 0;
		int sum = 300;
		int temp;
		
		N = item.length;
		marked = new boolean[N];
		
		for (i = 0; i < N; i++) {
			marked[i] = false;		
		}
		
		
		i = 0;
		j = N - 1;
		
		Arrays.sort(item);
		
		
		while ( i <= j) {
		
			temp = item[i] + item[j];
			
			if (temp <= sum) {
				minBins++;
				marked[i] = true;
				marked[j] = true;
				i++;			
			}
			j--;
		}
		
		for (i = 0; i < N; i++) {
		
			if (!marked[i])
				minBins++;

		}
		
		
		return minBins;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		BinPackingEasy obj;
		int answer;
		obj = new BinPackingEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.minBins(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new int[]{150,150,150,150,150};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{130,140,150,160};
		p1 = 2;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{101,101,101,101,101,101,101,101,101};
		p1 = 5;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{101,200,101,101,101,101,200,101,200};
		p1 = 6;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{123,145,167,213,245,267,289,132,154,176,198};
		p1 = 8;
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
