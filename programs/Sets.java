import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Sets
{
	public int[] operate(int[] A, int[] B, String operation)
	{
		int i;
		HashSet<Integer> set = new HashSet<>(A.length * 2);
		
		for (i = 0; i < A.length; i++)
			set.add(A[i]);
		
		if (operation.charAt(0) == 'U') {
			return union(set, B);
		}
		else if (operation.charAt(0) == 'I') {
			return intersection(set, B);
		}
		else {
			return symmetricDiff(set, B);
		}
	}
	
	public int[] union(HashSet<Integer> set, int[] B) {
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		int ansArray[];
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			intArr.add((Integer)iter.next());
		}
		for (int i = 0; i < B.length; i++) {
			if (!set.contains(B[i]))
				intArr.add(B[i]);
		}
		ansArray = new int[intArr.size()];
		int j = 0;
		for (int i : intArr) {
			ansArray[j++] = i;
		}
		Arrays.sort(ansArray);
		return ansArray;
		
	}
	
	public int[] intersection(HashSet<Integer> set, int[] B) {
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		int ansArray[];

		for (int i = 0; i < B.length; i++) {
			if (set.contains(B[i]))
				intArr.add(B[i]);

		}
		ansArray = new int[intArr.size()];
		int j = 0;
		for (int i : intArr) {
			ansArray[j++] = i;
		}
		Arrays.sort(ansArray);
		return ansArray;
	}
	
	public int[] symmetricDiff(HashSet<Integer> set, int[] B) {
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		int ansArray[];
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			intArr.add((Integer)iter.next());
		}

		for (int i = 0; i < B.length; i++) {
			if (!set.contains(B[i]))
				intArr.add(B[i]);
			else
				intArr.remove((Integer)B[i]);

		}
		ansArray = new int[intArr.size()];
		int j = 0;
		for (int i : intArr) {
			ansArray[j++] = i;
		}
		Arrays.sort(ansArray);
		return ansArray;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, String p2, boolean hasAnswer, int[] p3) {
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
		System.out.print("}" + "," + "\"" + p2 + "\"");
		System.out.println("]");
		Sets obj;
		int[] answer;
		obj = new Sets();
		long startTime = System.currentTimeMillis();
		answer = obj.operate(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p3.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p3[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p3.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p3[i]) {
						res = false;
					}
				}
			}
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
		String p2;
		int[] p3;
		
		// ----- test 0 -----
		p0 = new int[]{1,2,3,4};
		p1 = new int[]{3,4,5,6};
		p2 = "INTERSECTION";
		p3 = new int[]{3,4};
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,2,3,4};
		p1 = new int[]{3,4,5,6};
		p2 = "UNION";
		p3 = new int[]{1,2,3,4,5,6};
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{432,756,123};
		p1 = new int[]{534,76,1209};
		p2 = "INTERSECTION";
		p3 = new int[]{};
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{6,5,7,4};
		p1 = new int[]{7,6,4,10};
		p2 = "SYMMETRIC DIFFERENCE";
		p3 = new int[]{5,10};
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{342,654,897,312,76,23,78};
		p1 = new int[]{21,43,87,98,23,756,897,234,645,876,123};
		p2 = "SYMMETRIC DIFFERENCE";
		p3 = new int[]{21,43,76,78,87,98,123,234,312,342,645,654,756,876};
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