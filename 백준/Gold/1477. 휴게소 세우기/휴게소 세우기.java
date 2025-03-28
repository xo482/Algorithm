import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, L;
    static int[] road;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) + 1;
        L = Integer.parseInt(st.nextToken());
        road = new int[N + 2];
        road[0] = 0; road[1] = L;

        st = new StringTokenizer(br.readLine());
        for(int i = 2; i < N+2; i++) road[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(road);
        int start = 0;
        int end = L;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            int count = 0;
            for (int i = 0; i < N + 1; i++)
                count += (road[i + 1] - road[i] - 1) / mid;

            if (M <= count) start = mid;
            else end = mid;
        }
        System.out.println(end);
    }
}