
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		for (int t = 0; t < 3; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Coin[] coins = new Coin[N + 1];
			boolean[] dp = new boolean[100001];
			dp[0] = true;
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				coins[i] = new Coin(m, n);
				sum += (m * n);
				for (int j = 1; j <= n; j++) {
					dp[m * j] = true;
				}
			}
			if (sum % 2 == 1) {
				System.out.println(0);
				continue;
			}

			if (dp[sum / 2] == true) {
				System.out.println(1);
				continue;
			}
			for (int i = 1; i <= N; i++) {
				int m = coins[i].money;
				int n = coins[i].num;

				for (int j = sum / 2; j >= m; j--) {
					if (dp[j - m]) {
						for (int k = 1; k <= n; k++) {
							if (j - m + m * k > sum / 2)
								break;
							dp[j - m + m * k] = true;
						}
					}
				}
			}
			
			System.out.println(dp[sum/2] ? 1 : 0);

		}
	}

	public static class Coin {
		int money;
		int num;

		public Coin(int money, int num) {
			super();
			this.money = money;
			this.num = num;
		}

	}

}
