import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int[] list;
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        list = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solution(0,0,list);
        System.out.println(sb);
    }

    private static void solution(int start, int m, int[] list) {
        if (m == M) {
            for (int i = 0; i < M; i++) {
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i <N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list[m] = arr[i];
                solution(i, m+1, list);
                visit[i] = false;
            }
        }
    }
}