import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SpreadingNews
{
	public int V;
	public int [] time;
	
	public int minTime(int[] supervisors)
	{
		int i;
		int j;
		DiGraph G;
		
		V = supervisors.length;
		G = new DiGraph(V);
		
		time = new int[V];
		
		for (i = 1; i < V; i++) {
		
			G.addEdge(supervisors[i], i);
		
		}
		
		dfs(G, 0);
		
	/*	
		for (i = 0; i < V; i++) {
//			max = Math.max(max, time[i]);
			System.out.print(time[i] + " ");
		}
		
		System.out.println();
	*/	
		return time[0];
		
	}
	
	public void dfs(DiGraph G, int s) {
	
		int i;
		int j;
		int count = 0;
		ArrayList<Integer> t;
		
		t = new ArrayList<Integer>();
		
	//	System.out.println("source = " + s + "; time = " + time[s]);
		
		for (int v : G.adj(s)) {
		
			dfs(G, v);
			t.add(time[v]);		
			count++;
		
		}
		
		Collections.sort(t);
		
		i = 1;
		
		for (j = t.size() - 1; j >= 0; j--) {
		
			time[s] = Math.max(time[s], i + t.get(j));
			
//			System.out.println("time[" + s + "] = " + time[s] + "; time[" + t1.get(j) + i = " + i);
			
			i++;
		
		}
		
//		System.out.println("S = " + s + "; time = " + time[s]);	
	
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SpreadingNews obj;
		int answer;
		obj = new SpreadingNews();
		long startTime = System.currentTimeMillis();
		answer = obj.minTime(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new int[]{-1,0,0};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{-1,0,0,2,2};
		p1 = 3;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{-1,0,1,2,3};
		p1 = 4;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{-1,0,0,1,1,1,2,2,3,3,4,4,5,5,6,7,7,8,12,13,14,16,16,16};
		p1 = 7;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}

class DiGraph {

	private final int V;
	private Bag<Integer>[] adj;
	
	public DiGraph(int v) {
		this.V = v;
		adj = (Bag<Integer>[]) new Bag[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	
	public int getNodes(int v) {
		return adj[v].nodes();
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public int V() {
		return V;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}

class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int N;

	private class Node {
		private Item item;
		private Node next;
	}

	public Bag() {
		first = null;
		N = 0;
	}
	
	public int nodes() {
		return N;
	}

	public void add(Item w) {
		Node oldfirst = first;
		first = new Node();
		first.item = w;
		first.next = oldfirst;
		N++;
	}

	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!