import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

// SRM 148 Div 2

public class CeyKaps
{
	public String decipher(String typed, String[] switches)
	{
		char typedArray [] = typed.toCharArray();
		char key = 'A';
		int i;
		char val1;
		char val2;
		String temp[];
		HashMap<Character, Character> charSwitchMap = new HashMap<Character, Character>(26);
		
		for (i = 0; i < 26; i++) 
			charSwitchMap.put((char)(key + i), (char)(key + i));
		
		for (String str : switches) {
			temp = str.split(":");
			val1 = charSwitchMap.get(temp[0].charAt(0));
			val2 = charSwitchMap.get(temp[1].charAt(0));
//			System.out.println("Val1 = " + val1 + "; Val2 = " + val2 + "; temp[0].charAt(0) = " + temp[0].charAt(0) + "; temp[1].charAt(0) = " + temp[1].charAt(0));
			charSwitchMap.put(temp[0].charAt(0), val2);
			charSwitchMap.put(temp[1].charAt(0), val1);
		}
		
//		Iterator itr = charSwitchMap.entrySet().iterator();
//		while (itr.hasNext()) {
//			Map.Entry pairs = (Map.Entry) itr.next();
//			System.out.println(pairs.getKey() + " = " + pairs.getValue());
//		}
		
		for (i = 0; i < typedArray.length; i++) {
		
			for (Map.Entry<Character, Character> entry : charSwitchMap.entrySet()) {
	            if (entry.getValue().equals(typedArray[i])) {
	                typedArray[i] = (char)entry.getKey();
//	                System.out.println("typedArray[" + i + "] = " + typedArray[i]);
	                break;
				}
			}
//			typedArray[i] = charSwitchMap.get(typedArray[i]);
		}
		return String.valueOf(typedArray);
	}
		// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String[] p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		CeyKaps obj;
		String answer;
		obj = new CeyKaps();
		long startTime = System.currentTimeMillis();
		answer = obj.decipher(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String p2;
		
		// ----- test 0 -----
		p0 = "AAAAA";
		p1 = new String[]{"A:B","B:C","A:D"};
		p2 = "CCCCC";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "ABCDE";
		p1 = new String[]{"A:B","B:C","C:D","D:E","E:A"};
		p2 = "AEBCD";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "IHWSIOTCHEDMYKEYCAPSARWUND";
		p1 = new String[]{"W:O","W:I"};
		p2 = "WHOSWITCHEDMYKEYCAPSAROUND";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
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
