import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
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
        list = new int[M];


        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }


        solution(0,list);
        System.out.println(sb);
    }

    private static void solution(int m, int[] list) {
        if (m == M) {
            for (int i = 0; i < M; i++) {
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i <N; i++) {
            list[m] = arr[i];
            solution(m+1, list);
        }
    }
}