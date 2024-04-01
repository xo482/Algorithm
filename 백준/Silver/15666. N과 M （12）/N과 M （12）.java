import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] list;
    static int N;
    static int M;
    static StringBuilder sb;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[M];
        set = new TreeSet<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        N = set.size();
        arr = new int[N];

        int i = 0;
        for (Integer integer : set) {
            arr[i++] = integer;
        }

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

        for (int i = start; i <N; i++) {
            list[m] = arr[i];
            solution(i, m+1, list);
        }
    }
}