import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) tree[i] = Integer.parseInt(st.nextToken());

        int MIN = 0;
        int MAX = 1_000_000_000;
        int height = 0;


        while (true) {
            height = (MIN + MAX) / 2;
            long sum = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] > height){
                    sum += tree[i] - height;
                    cnt++;
                }
            }

            if (sum < M) {
                MAX = height;
            }
            if (sum > M) {
                if (sum - cnt < M) break;
                MIN = height;
            }
            if (sum == M) break;
        }

        System.out.println(height);
    }
}
