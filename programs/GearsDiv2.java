import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class GearsDiv2
{
	public int getmin(String Directions)
	{
//		List<Character> directions = new ArrayList<Character>();
		char [] startDir;
		char [] endDir;
		int startDirCount = 0;
		int endDirCount = 0;
		int len;
		int i;
		
		len = Directions.length();
		
		startDir = new char[len + 1];
		endDir = new char[len + 1];
		
		startDir[0] = Directions.charAt(len - 1);
//		startDir[len + 1] = Directions.charAt(0);
		for (i = 0; i < len; i++) {
			startDir[i + 1] = Directions.charAt(i);
			endDir[i] = Directions.charAt(i);
		}
		endDir[i] = Directions.charAt(0);
		
		System.out.println(startDir);
		System.out.println(endDir);
		
		for (i = 1; i <= len; i++) {
			if (startDir[i] != startDir[i - 1]) {
//				directions.add(startDir[i]);
				startDirCount++;
				continue;
			}
			else {
				startDir[i] = 'X';
			}
		}
		
		for (i = 0; i < len; i++) {
			if (endDir[i] != endDir[i + 1]) {
//				directions.add(endDir[i]);
				endDirCount++;
				continue;
			}
			else {
				endDir[i + 1] = 'X';
			}
		}
		
//		System.out.println(startDir);
//		System.out.println(directions);
		
		return Math.min(len - startDirCount, len - endDirCount);
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		GearsDiv2 obj;
		int answer;
		obj = new GearsDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getmin(p0);
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
		p0 = "LRRR";
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "RRR";
		p1 = 2;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "LRLR";
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "LRLLRRLLLRRRLLLL";
		p1 = 6;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "RRRRRRRLRRRRRRRLRLRLLRLRLRLRRLRLRLLLRLRLLRLLRRLRRR";
		p1 = 14;
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
