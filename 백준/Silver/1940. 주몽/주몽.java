import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, cnt = 0;
    static int[] nums;
    static boolean[] arr = new boolean[100001];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if (M>=200000) {System.out.println(0); return;}
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        for (int i : nums) arr[i] = true;

        for (int i : nums)
            if (i < M && arr[i] && arr[M - i] && i != M - i)
                cnt++;

        System.out.println(cnt/2);
    }
}