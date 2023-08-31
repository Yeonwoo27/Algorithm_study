
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 이 문제는 유향 그래프를 구현한다.
 * 똑같이 인접리스트를 구현하고
 * for문을 2~n번째 노드까지 돌린다
 * 각 노드의 value값이 W면 넘어가고 S면 실행
 * 시작할때 해당 노드의 양의 숫자를 들고 1번 섬으로 출발한다.
 * 지나가는길이 S면 넘어가고  W면 늑대의 숫자만큼 까인다
 * 1에 도착하면 정답을 저장할 변수 ans에 남은 양의 숫자를 더한다.
 */
public class Main{
	public static ArrayList<Integer>[] adjList;
	public static int N;
	public static long[] sNum; // 해당 인덱스의 양의 수. 늑대가 있으면 마이너스로 표현
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		sNum = new long[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String animal = st.nextToken();
			int aNum = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (animal.equals("S")) {
				sNum[i] = aNum;
			} else if (animal.equals("W")) {
				sNum[i] = -aNum;
			}

			adjList[idx].add(i);
			adjList[i].add(idx);

		}

		dfs(1,0);
		
		System.out.println(sNum[1]);

	}

	public static void dfs(int index, int bIndex) {

		visited[index] = true;
	
		for (int i = 0; i < adjList[index].size(); i++) {
			if (!visited[adjList[index].get(i)]) {
				dfs(adjList[index].get(i), index);
			}
		}
		if (sNum[index] > 0) { // 늑대가 아닌 양이 존재할 경우
			sNum[bIndex] += sNum[index];
		}

	}


}
