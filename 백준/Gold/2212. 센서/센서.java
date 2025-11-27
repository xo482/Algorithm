import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, ans = 0;
    static int[] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        for (int i = 0; i < N-1; i++) pq.add(arr[i+1] - arr[i]);
        

        for (int i = 0; i < N - K; i++) ans += pq.poll();
        System.out.println(ans);
    }
}