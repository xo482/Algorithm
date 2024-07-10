import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int INF = 1_000_000_001;
    static int[][] arr;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <N+1; i++) {
            for (int j = 0; j <N+1; j++) {
                arr[i][j] = INF;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[u][v] = Math.min(arr[u][v], val);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.print(distance[end]);
    }

    private static void dijkstra(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 0; i < N-1; i++) {
            int index = getSmallIndex();
            visited[index] = true;

            for (int j = 1; j < N + 1; j++)
                if (!visited[j] && distance[j] > distance[index] + arr[index][j])
                    distance[j] = distance[index] + arr[index][j];
        }
    }

    private static int getSmallIndex() {
        int min = INF+1;
        int index = -1;
        for (int i = 1; i < N + 1; i++) {
            if (min > distance[i] && !visited[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }
}