public class EllysCandyGame {
	public static int sweet[];
	public static int N;

	public String getWinner(int[] sweets) {
		String ans;
		int res;
		
		N = sweets.length;
		ans = "";
		
		sweet = sweets;
		
		res = wins(0);

		System.out.println("result = " + res);

		if (res == 0)
			ans = "Draw";
		else if (res > 0)
			ans = "Elly";
		else
			ans = "Kris";

		return ans;
	}

	public static int wins(int diff) {

		int i;
		int val;
		int res = Integer.MIN_VALUE;

		for (i = 0; i < N; i++) {
			if (sweet[i] != 0) {
				val = sweet[i];
				multiply(i);
				sweet[i] = 0;
				res = Math.max(-wins(-(diff + val)), res);
				restore(i);
				sweet[i] = val;
			}
		}
		
		return res == Integer.MIN_VALUE ? diff : res;
	}

	public static void multiply(int i) {

		if (i - 1 >= 0)
			sweet[i - 1] *= 2;
		if (i + 1 < N)
			sweet[i + 1] *= 2;

	}

	public static void restore(int i) {

		if (i - 1 >= 0)
			sweet[i - 1] /= 2;
		if (i + 1 < N)
			sweet[i + 1] /= 2;

	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0,
			boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		EllysCandyGame obj;
		String answer;
		obj = new EllysCandyGame();
		long startTime = System.currentTimeMillis();
		answer = obj.getWinner(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0
				+ " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		String p1;

		// ----- test 0 -----
		p0 = new int[] { 20, 50, 70, 0, 30 };
		p1 = "Kris";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 42, 13, 7 };
		p1 = "Elly";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 10, 20 };
		p1 = "Draw";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 3, 1, 7, 11, 1, 1 };
		p1 = "Kris";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] { 41, 449, 328, 474, 150, 501, 467, 329, 536, 440 };
		p1 = "Kris";
		// all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new int[] { 177, 131, 142, 171, 411, 391, 17, 222, 100, 298 };
		p1 = "Elly";
		// all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		if (all_right) {
			System.out
					.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
