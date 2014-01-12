import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PeopleCircle
{
	public String order(int numMales, int numFemales, int K)
	{
		int k;
		int i = 0;
		int index = 0;
		int factor;
		int total = numMales + numFemales;
		char [] ans = new char[total];
		String answer = "";

		ArrayList<Character> temp = new ArrayList<Character>();
		
		for (i = 0; i < total; i++) {
			ans[i] = 'M';
			temp.add('M');
		}
		
		k = K % total;
		if (k == 0)
			k = total;
		i = k - 1;
		index = i;
		int sTotal = total;
		int j = 1;
		
		while(numFemales-- > 0) {
			if (i >= total)
				i = i % total;
			if (index >= sTotal)
				index = index % sTotal;
			temp.remove(i);
			ans[index] = 'F';
			i += k - 1;
			index = i + j;
			total--;
			j++;
		}
		
		for (char var: temp)
			answer += var;
			
		return String.valueOf(ans);
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, boolean hasAnswer, String p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		PeopleCircle obj;
		String answer;
		obj = new PeopleCircle();
		long startTime = System.currentTimeMillis();
		answer = obj.order(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p3 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p3);
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
		String p3;
		
		// ----- test 0 -----
		p0 = 5;
		p1 = 3;
		p2 = 2;
		p3 = "MFMFMFMM";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 7;
		p1 = 3;
		p2 = 1;
		p3 = "FFFMMMMMMM";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 25;
		p1 = 25;
		p2 = 1000;
		p3 = "MMMMMFFFFFFMFMFMMMFFMFFFFFFFFFMMMMMMMFFMFMMMFMFMMF";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 5;
		p1 = 5;
		p2 = 3;
		p3 = "MFFMMFFMFM";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 1;
		p1 = 0;
		p2 = 245;
		p3 = "M";
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
