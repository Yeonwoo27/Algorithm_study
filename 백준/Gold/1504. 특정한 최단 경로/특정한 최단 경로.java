
/*
 * 인접리스트를 만든다.
 * 최단거리 구하기였으면 bfs를 사용했을 것이다
 * 근데 거쳐야하는 정점을 구하려면 끝까지 탐색을 해야하므로 dfs를 돌릴것이다.
 * 대신 visited 배열을 만들어서 같은경로로는 못가도록 만든다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int N, E;
	public static ArrayList<Node>[] adjList;
	public static final int INF=200000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			adjList[from].add(new Node(to, value));
			adjList[to].add(new Node(from, value));
		}

		st = new StringTokenizer(br.readLine());

		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int routeA = 0;
		int routeB = 0;
		routeA = (dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, N));
		routeB = (dijkstra(1, v) + dijkstra(v, u) + dijkstra(u, N));

		if (routeA >= INF && routeB >= INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(routeA, routeB));
	}

	public static int dijkstra(int start, int to) {
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {

			int nowIndex = pq.poll().index;

			if (visited[nowIndex])
				continue;
			visited[nowIndex] = true;

			for (Node next : adjList[nowIndex]) {
				if (!visited[next.index]&&dist[next.index] > dist[nowIndex] + next.cost) {
					dist[next.index] = dist[nowIndex] + next.cost;
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}

		return dist[to];

	}

	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}

}
