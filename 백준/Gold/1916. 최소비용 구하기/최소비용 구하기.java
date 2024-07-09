import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int INF = 1_000_000_001;
    static int[][] weight;
    static int[] nodeList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        weight = new int[N + 1][N + 1];
        nodeList = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <N+1; i++) {
            for (int j = 0; j <N+1; j++) {
                weight[i][j] = INF;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            weight[u][v] = Math.min(weight[u][v], val);
        }

        st = new StringTokenizer(br.readLine());
        dijkstra(Integer.parseInt(st.nextToken()));
        System.out.print(nodeList[Integer.parseInt(st.nextToken())]);
    }

    private static void dijkstra(int start) {
        Arrays.fill(nodeList, INF);
        nodeList[start] = 0;

        for (int i = 0; i < N; i++) {
            int index = getSmallIndex();
            if (index == -1) continue;
            visited[index] = true;

            for (int j = 1; j < N + 1; j++) {
                if (!visited[j]) {
                    if (nodeList[j] > nodeList[index] + weight[index][j]) {
                        nodeList[j] = nodeList[index] + weight[index][j];
                    }
                }
            }
        }
    }

    private static int getSmallIndex() {
        int min = INF;
        int index = -1;
        for (int i = 1; i < N + 1; i++) {
            if (min > nodeList[i] && !visited[i]) {
                min = nodeList[i];
                index = i;
            }
        }
        return index;
    }
}