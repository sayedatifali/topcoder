import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class GroupWork
{

	private class Group implements Comparable<Group> {
	
		int p;
		int s;
		
		public Group(int p, int s) {
		
			this.p = p;
			this.s = s;
		
		}
		
		@Override
		public int compareTo(Group x) {
		
			if (this.s > x.s)
				return 1;
			else if (this.s < x.s)
				return -1;
					
			return 1;
		
		}
	
	}

	public long bestGroup(int[] p, int[] s)
	{
		int i;
		int j;
		int N;
		long ans;
		long temp;
		long count;
		Group group[] = new Group[p.length];
		
		N = p.length;
		
		ans = 0;
		
		for (i = 0; i < N; i++) {
		
			group[i] = new Group(p[i], s[i]);
		
		}
		
		Arrays.sort(group);
		temp = 0;
		count = 0;
		
		for (i = N - 1; i >= 0; i--) {
		
			count += group[i].p;
			
			temp = group[i].s * count;
			
			ans = Math.max(temp, ans);		
		
		}
		
		
		return ans;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, long p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		GroupWork obj;
		long answer;
		obj = new GroupWork();
		long startTime = System.currentTimeMillis();
		answer = obj.bestGroup(p0, p1);
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
		int[] p1;
		long p2;
		
		// ----- test 0 -----
		p0 = new int[]{1,2,1};
		p1 = new int[]{3,5,9};
		p2 = 15L;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{2,2,2,2};
		p1 = new int[]{5,1,1,5};
		p2 = 20L;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		p1 = new int[]{31,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		p2 = 31L;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1000000000,1000000000,1000000000};
		p1 = new int[]{1000,999,998};
		p2 = 2994000000000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
