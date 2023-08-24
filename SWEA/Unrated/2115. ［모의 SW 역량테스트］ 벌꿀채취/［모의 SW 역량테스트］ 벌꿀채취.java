

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 두명의 일꾼이 존재. 각 일꾼은 가로길이 M만큼 꿀 채취가능
 * 두 일꾼이 각각 채취할 수 있는 꿀의 최대 양은 C
 * 일꾼은 한칸씩 채취를 진행해야한다.
 * 각 용기에 있는 꿀의 양의 제곱만큼 수익이 생기므로 가능한 큰숫자 칸을 채취하는게 무조건 이득
 * 
 * 풀이 : 완전탐색? 길이 M의 블럭에서 부분집합을 통해 하나씩 조건을 만족하는지 확인하고, 만족한다면 최대값 비교를 해본다.
 * 
 */
public class Solution {
	public static int T;
	public static int N, M, C, ans, sum1, sum2;
	public static int[][] arr;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[M];
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sum1 = 0;
			sum2 = 0;
			choice();

			System.out.println("#" + test_case + " " + ans);
		}
	}

	public static void choice() {
		boolean[][] check = new boolean[N][N];
		boolean overlap; // 겹치는지 체크할 boolean변수

		for (int i = 0; i < N; i++) { // 첫번째 벌통
			for (int j = 0; j <= N - M; j++) {

				for (int k = 0; k < M; k++) {
					check[i][j + k] = true;
				}

				for (int a = 0; a < N; a++) { // 두번째 벌통
					for (int b = 0; b <= N - M; b++) {
						overlap = true;
						for (int c = 0; c < M; c++) {
							if (check[a][b + c]) {
								overlap = false;
								break;
							}
						}
						if (!overlap)
							continue; // 겹치면 break

						getHoney(i, j, a, b, 0);
						ans = Math.max(ans, sum1 + sum2);
						sum1 = 0;
						sum2 = 0;
					}

				}
				// 두번째 벌통 끝나고나서 첫번째 벌통 check true였던거 다시 false로
				for (int k = j; k < j + M; k++) {
					check[i][k] = false;
				}

			}
		}
	}

	public static void getHoney(int i, int j, int a, int b, int cnt) {
		if (cnt == M) {
			int honey1 = 0, honey2 = 0, h1 = 0, h2 = 0;
			for (int k = 0; k < M; k++) {
				if (visited[k]) {
					honey1 += arr[i][j + k];
					h1 += (int) Math.pow(arr[i][j + k], 2);
					honey2 += arr[a][b + k];
					h2 += (int) Math.pow(arr[a][b + k], 2);
				}
			}

			if (honey1 <= C)
				sum1 = Math.max(sum1, h1);
			if (honey2 <= C)
				sum2 = Math.max(sum2, h2);

			return;
		}

		visited[cnt] = true;
		getHoney(i, j, a, b, cnt + 1);
		visited[cnt] = false;
		getHoney(i, j, a, b, cnt + 1);
	}

}
