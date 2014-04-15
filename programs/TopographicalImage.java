import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TopographicalImage
{
	public boolean marked[][];
	public int My, Nx;
	public int dy[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
	public int dx[] = new int[] {-1, 0, 1, -1, 1, -1, 0 , 1};
	
	public int[] calcPeakAreas(String[] topoData)
	{
		int i, j;
		char c;
		ArrayList<Integer> area;
		int [] ans;
		int a;
		Point pt;
		
		My = topoData.length;
		Nx = topoData[0].length();
		
		area = new ArrayList<Integer>();
		marked = new boolean[My][Nx];
		
		
		while ((pt = getNextPeak(topoData)) != null) {
		
			a = dfs(topoData, pt, pt);
			area.add(a);		
		
		}
		
		ans = new int[area.size()];
		i = 0;	
		for (int ar: area) {
			System.out.println(ar);
			ans[i++] = ar;	
		}
		
	//	return area.toArray(new int[area.size()]);
		return ans;	
	}
	
	public int dfs(String [] topoData, Point from, Point pt) {
	
		int area = 1;
		int i, j;
		Point p;
		
		if (pt.x < 0 || pt.x >= Nx)
			return 0;
			
		if (pt.y < 0 || pt.y >= My)
			return 0;
			
		if (marked[pt.y][pt.x] || (topoData[from.y].charAt(from.x) < topoData[pt.y].charAt(pt.x)))
			return 0;
		
		marked[pt.y][pt.x] = true;
		
		p = new Point(pt.x, pt.y);
		
		for (i = 0; i < dy.length; i++) {
		
			p.x = pt.x + dx[i];
			p.y = pt.y + dy[i];
			
			area += dfs(topoData, pt, p);
		
		}
		
		
		return area;	
	}
	
	public Point getNextPeak(String [] topoData) {
	
		int i;
		int j;
		char c = 32;
		Point p = null;
		
//		p = new Point();
		
		for (i = 0; i < My; i++) {
		
			for (j = 0; j < Nx; j++) {
			
				if (!marked[i][j] && c < topoData[i].charAt(j)) {
					c = topoData[i].charAt(j);
					if (p == null)
						p = new Point(j, i);
					else {
						p.x = j;
						p.y = i;
					}
				}
			
			}
		
		}
		
		return p;		
	
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		TopographicalImage obj;
		int[] answer;
		obj = new TopographicalImage();
		long startTime = System.currentTimeMillis();
		answer = obj.calcPeakAreas(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p1.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p1[i]);
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
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p1[i]) {
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
		
		String[] p0;
		int[] p1;
		
		// ----- test 0 -----
		p0 = new String[]{"............","....i..i....","....i..i....",".o..i..i..o.",".o........o.","..oooooooo..","............"};
		p1 = new int[]{78,3,3};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"............","....i..i....","....i..i....",".S..i..i..Y.",".M........E.","..ILEYSMIL..","............"};
		p1 = new int[]{69,3,2,5,3,1,1};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"zzzzzzzzzzzzz","z...........z","z...c.b.c...z","z....bab.b..z","z...c.b.c...z","z...........z","zzzzzzzzzzzzz"};
		p1 = new int[]{81,6,2,1,1};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"!"};
		p1 = new int[]{1};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"AAAAAAABBBBCCCDEFGHHIIJIIHGFEDDCCCBBBBBBBBBBAAAAAA","AAAAABBBBBCCDDEEFGHIJJJJIIHGFEDDCCCCCCCCCBBBBBAAAA","AAAABBBBCCCDDEEFGHIIJJJJJIHGFEDDDDDDDDDCCCCBBBBAAA","AAABBBBCCDDEEFFGHHIJJJJJJIHGFEEDDDDDEEDDDDCCBBBBAA","AABBBCCDDEEFFGGHHIIJJJJJIHHGFEEEEEEEFFFEEDDCCBBBAA","BBBBCCDDEFFGHHHIIIIJJJIIIHGFFEEEEFFGGGGGFEEDCCBBBA","BBBCCDEEFGHIIIJJJJIIIIIHHGGFFEEFFGGHHHHHGGFEDCCBBB","BBCCDEEGHIJJKKKKJJJIIHHGGFFEEEEFGGHIIJJIIHGFEDCCBB","CCCDEEFHIJKLMMMLKKJIHHGGFFEEEEFFGHIJJKKJJIHGFEDCBB","CDDEEFHIJLMNNNNMLKJIHGFFEEEDEEFFGIJKKLLLKJIHFEDCCB","DDEFFGIJLMNOPPONMLJIHGFEEDDDDEFGHIJKLMMMLKJIGFEDCB","EEFFGHIKMNOQQQPONLKIHFEEDDDDDEFGHIKLMMNMMLKIHGEDCC","FFGGHIJLMOPQRRQPNMKIGFEDDCCDDEFGHIKLMNNNNMLJIGFEDC","GHHHIJKLNOQRRRQPOMKIGFEDDCCDDEFGHIKLMNNNNMLKIHFEDC","HIIIJJKLNOPQRRQPNLKIGFEDDCCDDEFGHJKLMNOONNMKJHGFDC","IJJJJJKLMOPQQQPONLJHGFEDDDDDEEFGIJKLMNOONNMLJIGFED","JJJJJKKLMNOOPPONMKJHGFEDDDDEEFGHIJKLMNNONNMLJIGFED","JKKJJJKKLMMNNNNMLJIHFFEEEEEFGGHIJKLMMNNNNMMKJIGFED","KKKJJJJJKKLLMLLKJIHGFFEEEFFGHIJKKLMMNNNNNMLKJH" +
				"GFED","JJJJIIIIIJJJKKJJIIHGFFFFFGHIJKLMMNNNNNNMMLKJIHGEDC","JJJIIHHHHHHIIIIIHHGGGGGGHIJKLMNOOOOONNMMLKJIHGFEDC","IIIHHGGGGGGGGHHHGGGGGGHIIJLMNOPQQQQPONMLKJIHGFEDDC","HHHGGFFFFFFFFFGGGGGGHHIJKMNOQRSSSSRQPNMLKIHGFFEDCC","GGGFFEEEEEEEEFFFGGGHIJKLMOPRSTUUUTSRPNMKJHGFFEDCCB","FFFEEEEDDDDEEEEFGGHIJKLNOQRTUVWWWVTRPNLJIHFEEDCCBB","EEEEDDDDDDDDEEEFGHIJKLNOQRTVWXYYXWUSPNLJHGFEDCCBBB","DDDDDDDDDDDEEEFFGHIKLNOQRTVWXYZYYWURPMKIGFEDCCBBBB","CDDDDDDEEEEEEFFGHIJKMOPRSUWXYZZZXWTROMJHGEDCCBBBBA","CCDDDEEEFFFFFGGHHJKLNOQRTVWXYZZYXVTQNLIGFEDCBBBAAA","CCDDEFFGGGGHHHHIIJKMNPQSTVWXYYYXVURPMKIGEDCBBBAAAA","CDDEFGGHIIIIIIIJJKLMOPQSTUVWWXWVUSQNLJHFECCBBBAAAA","CDEFGHIJKKKKKKKKKLMNOPQRSTUVVVUTSQOMJHGEDCBBBAAAAA","CDEGHIKLMMMMMMLLLMMNOPQRSSTTTTSRQOMKIGFDCCBBAAAAAA","DEFGIKLMNOOOONNMMMNNOPQQRRRRRRQPNMKIHFEDCBBBAAAAAA","DEGHJLMOPQQQPPOONNNOOPPPQQQPPONMLKIHFEDCBBBAAAAAAA","DEGIKMNPQRRRRQPOOOOOOOPPPOOONMLKJIHFEDCCBBAAAAAAAA","DFGIKMOQRSSSRRQPOOOOOOOOONMMLKJIHGFEDCCBBBAAAAAAAA","DFGIKMOQRSSSRRQPOOOOONNNMMLKJIIHGFEDCCBB" +
				"BAAAAAAAAA","DEGIJLNPQRRRRQPOONNNNNMMLLKJIHGFEEDCCBBBAAAAAAAAAA","DEFHJKMOPQQQQPOONNMMMMLLKJIHGGFEDDCCBBBAAAAAAAAAAA","CDFGIJLMNOOOONNMMLLLLLKKJIHGFEEDCCCBBBAAAAAAAAAAAA","CDEFGIJKLMMMMMLLKKKKKJJIIHGFEDDCCBBBBAAAAAAAAAAAAA","CCDEFGHIJKKKKKJJJIIIIIHHGGFEDDCCBBBBAAAAAAAAAAAAAA","BCCDEFGHHIIIIIHHHHHHHGGGFFEDDCCBBBAAAAAAAAAAAAAAAA","BBCCDEEFFGGGGGGFFFFFFFFEEDDCCCBBBAAAAAAAAAAAAAAAAA","BBBCCDDEEEEEEEEEEEEEEEEDDDCCBBBBAAAAAAAAAAAAAAAAAA","ABBBCCCCDDDDDDDDDDDDDDDCCCCBBBBAAAAAAAAAAAAAAAAAAA","AABBBBBCCCCCCCCCCCCCCCCCCBBBBBAAAAAAAAAAAAAAAAAAAA","AAABBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAA","AAAAAABBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAA"};
		p1 = new int[]{1918,65,483,5,5,24};
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

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
	
		this.x = x;
		this.y = y;
	
	}

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
