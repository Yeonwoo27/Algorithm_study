import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * RxC 격자판에서 낚시를 한다
 * 상어는 크기와 속도를 가지고 있음
 * 낚시왕의 초기 위치는 (0,0). 낚시왕의 열 값이 C+1이 되면 종료
 * 	 행동	순서	 1. (r,c)에서 (r,c+1)
 * 			 2. (1,c)~(r,c) 반복문 돌았을때 먼저 만나는 상어 잡기.
 * 			 3. 상어가 움직임
 * 상어 움직이는 방향 : 상 하 우 좌 (1,2,3,4)
 * 상어가 움직이다가 벽을 만나면 방향을 반대로. 즉 1은 2로, 2는 1로, 3은 4로, 4는 3으로
 * 두 마리 이상의 상어가 겹치면 큰 상어만 살아남는다.
 * 낚시왕이 잡은 크기의 합을 출력하라
 * 
 * 풀이 : 그냥 위의 조건대로 구현하기.
 */
public class Main {
	public static int R, C, M;
	public static Shark[][] arr;
	public static int ans = 0;
	public static int[] dx = { 0, -1, 1, 0, 0 }; // 가만히 ,상, 하 ,우 ,좌
	public static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[r][c] = new Shark(r, c, s, d, z);

		}

		for (int i = 1; i <= C; i++) {
			getShark(i);
			moveShark();
		}

		System.out.println(ans);
	}

	public static void getShark(int c) {
		for (int i = 1; i <= R; i++) {
			if (arr[i][c] != null) { // 해당 열에서 처음으로 상어를 만나면 실행
				ans += arr[i][c].z; // 만난 상어의 무게만큼 ans에 더해준다.
				arr[i][c] = null; // 해당 상어를 없애준다.
				break;
			}
		}
	}

	public static void moveShark() {
		Queue<Shark> sQueue = new LinkedList<>();

		for (int i = 1; i <= R; i++) { // 살아있는 상어들을 큐에 넣어준다.
			for (int j = 1; j <= C; j++) {
				if (arr[i][j] != null) {
					sQueue.add(arr[i][j]);
				}
			}
		}
		arr = new Shark[R + 1][C + 1]; // 상어 배열 초기화

		while (!sQueue.isEmpty()) { // 큐에 들어있는 상어 움직여주기
			Shark s = sQueue.poll();
			move(s);
		}

	}

	public static void move(Shark s) {
		int cx = s.r;
		int cy = s.c;
		int d = s.d;
		for (int i = 0; i < s.s; i++) {
			cx += dx[d];
			cy += dy[d];

			if (cx <= 0 || cy <= 0 || cx > R || cy > C) { //범위를 벗어나면 원래 위치로 돌아오고 방향을 반대로 바꿔준다.
				cx -= dx[d];
				cy -= dy[d];

				if (d == 1) {
					d = 2;
				} else if (d == 2) {
					d = 1;
				} else if (d == 3) {
					d = 4;
				} else if (d == 4) {
					d = 3;
				}
				cx += dx[d];
				cy += dy[d];
			}
		}

		if (arr[cx][cy] != null) { // 다른 상어가 들어와있는 곳이면 크기를 비교
			if (arr[cx][cy].z > s.z) { // 기존 상어가 더 크면 종료
				return;
			}
		}
		arr[cx][cy] = new Shark(cx, cy, s.s, d, s.z); // 새로 들어온 상어가 더 크면 교체
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

}
