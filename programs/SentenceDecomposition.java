import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SentenceDecomposition
{
	public int decompose(String sentence, String[] validWords)
	{
		int i;
		int j;
		int dp[];
		int len;
		int x;
		
		len = sentence.length();
		
		dp = new int[len];
		
//		System.out.println(compare("neo", 0, 2, new String[] {"one","two","three","there"}));
		
		
		for (i = 0; i < len; i++)
			dp[i] = -1;
			
		dp[0] = compare(sentence, 0, 0, validWords);
		
//		System.out.println("dp[0] = " + dp[0]);
		
		for (i = 1; i < len; i++) {
		
			dp[i] = compare(sentence, 0, i, validWords);
//			System.out.println("Initial dp[" + i + "] = " + dp[i]);
			
			for (j = 0; j < i; j++) {
			
				if (dp[j] == -1) {
					continue;				
				}
				
				x = compare(sentence, j + 1, i, validWords);
				
				if (x == -1)
					continue;
				
				if (x + dp[j] < dp[i] || dp[i] == -1)
					dp[i] = x + dp[j];			
			}
		
		}
				
		return dp[len - 1];
	}
	
	
	public int compare(String sentence, int p, int q, String [] validWord) {
	
		int i;
		int j;
		int num;
		int arr[];
		int min = -1;
		int N;
		int count;
		int invalid = 0;
		
		num = validWord.length;
		N = q - p + 1;
		
		for (i = 0; i < num; i++) {
			count = 0;
			invalid = 0;
			arr = new int[26];
			
			if (validWord[i].length() != N)
				continue;
				
			for (j = p; j <= q; j++) {
				arr[validWord[i].charAt(j - p) - 'a']++;
				arr[sentence.charAt(j) - 'a']--;
			}
			
			for (j = 0; j < 26; j++) {
				if (arr[j] != 0) {
					invalid = 1;
					break;
				}
			}
			
			if (invalid == 1)
				continue;
			
			for (j = 0; j < N; j++) {
				if (sentence.charAt(j + p) != validWord[i].charAt(j))
					count++;			
			}
			
			if (min == -1 || count < min)
				min = count;			
		
		}
		
		return min;		
	
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SentenceDecomposition obj;
		int answer;
		obj = new SentenceDecomposition();
		long startTime = System.currentTimeMillis();
		answer = obj.decompose(p0, p1);
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
		
		String p0;
		String[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = "neotowheret";
		p1 = new String[]{"one","two","three","there"};
		p2 = 8;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "abba";
		p1 = new String[]{"ab","ac","ad"};
		p2 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "thisismeaningless";
		p1 = new String[]{"this","is","meaningful"};
		p2 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "ommwreehisymkiml";
		p1 = new String[]{"we","were","here","my","is","mom","here","si","milk","where","si"};
		p2 = 10;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "ogodtsneeencs";
		p1 = new String[]{"go","good","do","sentences","tense","scen"};
		p2 = 8;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "sepawaterords";
		p1 = new String[]{"separate","words"};
		p2 = -1;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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