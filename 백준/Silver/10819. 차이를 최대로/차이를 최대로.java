import java.util.*;

public class Main {
    static int[] arr;
    static int[] nums;
    static boolean[] visited;
    static int n, ans = 0;

    public static void dfs(int cnt) {
        if (cnt==n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i=0;i<n;i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[cnt] = nums[i];
            dfs(cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n];
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(ans);
    }
}