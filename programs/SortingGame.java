import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SortingGame
{
	public static int sBoard[];
	public static HashMap<List<Integer>, Integer> sHashMap;
	public static List<Integer> sArrayList;
	
	public int fewestMoves(int[] board, int k)
	{
		List<Integer> lBoard = new ArrayList<Integer>();
		sHashMap = new HashMap<List<Integer>, Integer>();
		for (int i = 0; i < board.length; i++)
			lBoard.add(board[i]);
		sArrayList = new ArrayList<Integer>();
		getMoves(lBoard, k, 0);
	
		if(sArrayList.size() == 0)
			return -1;
		
		Collections.sort(sArrayList);
		
		for (int i : sArrayList)
			System.out.print(i + ", ");
		
		return sArrayList.get(0);
	}
	
	public void getMoves(List<Integer> board, int k, int depth) {
	
		int i;
		List<Integer> newBoard;
		List<Integer> qBoard;
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		
		queue.add(board);
		sHashMap.put(board, depth);
//		depth = sHashMap.get(board);
		
		while ((qBoard = queue.poll()) != null) {
		
			depth = sHashMap.get(qBoard);
		
//			for (int xy : qBoard)
//				System.out.print(xy + " ");
//			System.out.println();
			
			for (i = 0; i < qBoard.size() - 1; i++) {
				if (qBoard.get(i) > qBoard.get(i + 1))
					break;		
			}
			if (i == qBoard.size() - 1) {
				System.out.println("Depth: " + depth);
				sArrayList.add(depth);
				return;
			}
		
			for (i = 0; i <= qBoard.size() - k; i++) {
			
				newBoard = new ArrayList<Integer>();
				
				for (int j = 0; j < qBoard.size(); j++)
					newBoard.add(qBoard.get(j));
				
	//			for (int l = 0; l < newBoard.size(); l++)
	//				System.out.print(newBoard.get(l) + " ");
				
	//			System.out.println("Iterations: " + depth);
				
				reverse(newBoard, i, i + k - 1);
				
				if (sHashMap.containsKey(newBoard)) {
		//			System.out.println("Contains Key");
					continue;
				}
				
				sHashMap.put(newBoard, depth + 1);
				queue.add(newBoard);
	
			}
		
		}

	}
	
	
	public void reverse(List<Integer> board, int start, int end) {
	
		int temp;
		
		while (start < end) {
			temp = board.get(start);
			board.set(start, board.get(end));
			board.set(end, temp);
			start++;
			end--;
		}
	
	
	}
		// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		SortingGame obj;
		int answer;
		obj = new SortingGame();
		long startTime = System.currentTimeMillis();
		answer = obj.fewestMoves(p0, p1);
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
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{1,2,3};
		p1 = 3;
		p2 = 0;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{3,2,1};
		p1 = 3;
		p2 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{5,4,3,2,1};
		p1 = 2;
		p2 = 10;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{3,2,4,1,5};
		p1 = 4;
		p2 = -1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{7,2,1,6,8,4,3,5};
		p1 = 4;
		p2 = 7;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
