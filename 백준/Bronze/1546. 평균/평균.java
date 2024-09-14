import java.io.*;
import java.util.*;

// 1에서 N까지 가는데 필수로 지나가야하는 v1, v2가 주어진다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static double max = 0, sum = 0;
    static int[] list;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, list[i]);
            sum += list[i];
        }

        System.out.println(sum / max * 100 / N);
    }
}