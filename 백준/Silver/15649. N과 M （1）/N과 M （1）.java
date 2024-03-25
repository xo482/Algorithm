import java.io.*;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int N,M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        // 노드의 개수
        N = Integer.parseInt(str[0]);

        // 방문 가능한 노드의 최대 길이
        M = Integer.parseInt(str[1]);

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);

    }

    private static void dfs(int depth) {

        if (depth == M){
            sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}