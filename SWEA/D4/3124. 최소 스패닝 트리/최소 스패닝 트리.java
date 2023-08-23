

import java.util.*;
import java.io.*;

class Solution {
	public static int V, E;
	public static Node[] list;
	public static int[] arr;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new Node[E];
			arr = new int[V + 1];

			int A, B, C;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());

				list[i] = new Node(A, B, C);
			}
			Arrays.sort(list);

			for (int i = 1; i <= V; i++) {
				arr[i] = i;
			}
			long result = 0;
			for (Node n : list) {
				if (union(n.from, n.to)) {
					result += n.weight;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		else {
			arr[bRoot] = aRoot;
			return true;
		}
	}

	public static int find(int a) {
		if (arr[a] == a)
			return a;
		return arr[a] = find(arr[a]);
	}

	public static class Node implements Comparable<Node> {
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {

			return Integer.compare(this.weight, o.weight);
		}

	}
}
