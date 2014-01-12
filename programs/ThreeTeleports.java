import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ThreeTeleports
{
	int x1[], x2[];
	int y1[], y2[];
	long minDist;
	
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports)
	{
		int i;
		int j;
		boolean marked[];
		StringTokenizer st;
		
		minDist = Math.abs(xMe - xHome) + Math.abs(yMe - yHome);
		x1 = new int[3];
		x2 = new int[3];
		y1 = new int[3];
		y2 = new int[3];
		marked = new boolean[3];
		
		for (i = 0; i < 3; i++) {
			st = new StringTokenizer(teleports[i]);
			marked[i] = false;
			
			x1[i] = Integer.parseInt(st.nextToken());
			y1[i] = Integer.parseInt(st.nextToken());
			x2[i] = Integer.parseInt(st.nextToken());
			y2[i] = Integer.parseInt(st.nextToken());
			
	//		System.out.println("x1 = " + x1[i] + "; y1 = " + y1[i] + "; x2 = " + x2[i] + "; y2 = " + y2[i]);
		}
		
		dfs(xMe, yMe, xHome, yHome, marked, 0);
		
		
		return (int) minDist;
		
	}
	
	public void dfs(int xMe, int yMe, int xHome, int yHome, boolean [] marked, long dist) {
		
		long directDist;
		long tempDist1;
		long tempDist2;
		
		directDist = Math.abs(xMe - xHome) + Math.abs(yMe - yHome);
		
//		System.out.println("directDist = " + directDist + "; dist = " + dist + "; Total Dist = " + (directDist + dist));
		
		if (directDist + dist < minDist)
			minDist = directDist + dist;
		
//		if (directDist == 0)
//			return;
		
		for (int i = 0; i < marked.length; i++) {
			if (marked[i])
				continue;
			marked[i] = true;
			tempDist1 = Math.abs(x1[i] - xMe) + Math.abs(y1[i] - yMe) + dist + 10;
			tempDist2 = Math.abs(x2[i] - xMe) + Math.abs(y2[i] - yMe) + dist + 10;
//			System.out.println("xMe = " + xMe + "; yMe = " + yMe + "; x1 = " + x1[i] + "; y1 = " + y1[i] + "; x2 = " + x2[i] + "; y2 = " + y2[i] + "; tempdist1 = " + tempDist1);
			dfs(x2[i], y2[i], xHome, yHome, marked, tempDist1);
//			System.out.println("xMe = " + xMe + "; yMe = " + yMe + "; x1 = " + x1[i] + "; y1 = " + y1[i] + "; x2 = " + x2[i] + "; y2 = " + y2[i] + "; tempdist2 = " + tempDist2);
			dfs(x1[i], y1[i], xHome, yHome, marked, tempDist2);
			marked[i] = false;
		
		}
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, String[] p4, boolean hasAnswer, int p5) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + "{");
		for (int i = 0; p4.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p4[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		ThreeTeleports obj;
		int answer;
		obj = new ThreeTeleports();
		long startTime = System.currentTimeMillis();
		answer = obj.shortestDistance(p0, p1, p2, p3, p4);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p5);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p5;
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
		int p3;
		String[] p4;
		int p5;
		
		// ----- test 0 -----
		p0 = 3;
		p1 = 3;
		p2 = 4;
		p3 = 5;
		p4 = new String[]{"1000 1001 1000 1002","1000 1003 1000 1004","1000 1005 1000 1006"};
		p5 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 0;
		p1 = 0;
		p2 = 20;
		p3 = 20;
		p4 = new String[]{"1 1 18 20","1000 1003 1000 1004","1000 1005 1000 1006"};
		p5 = 14;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 0;
		p1 = 0;
		p2 = 20;
		p3 = 20;
		p4 = new String[]{"1000 1003 1000 1004","18 20 1 1","1000 1005 1000 1006"};
		p5 = 14;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 10;
		p1 = 10;
		p2 = 10000;
		p3 = 20000;
		p4 = new String[]{"1000 1003 1000 1004","3 3 10004 20002","1000 1005 1000 1006"};
		p5 = 30;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 3;
		p1 = 7;
		p2 = 10000;
		p3 = 30000;
		p4 = new String[]{"3 10 5200 4900","12212 8699 9999 30011","12200 8701 5203 4845"};
		p5 = 117;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, true, p5) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 0;
		p1 = 0;
		p2 = 1000000000;
		p3 = 1000000000;
		p4 = new String[]{"0 1 0 999999999","1 1000000000 999999999 0","1000000000 1 1000000000 999999999"};
		p5 = 36;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, p4, true, p5) && all_right;
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
