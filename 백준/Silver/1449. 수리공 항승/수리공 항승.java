import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) arr[N] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int pass = 0, cnt = 0;
        for (int now : arr) {
            if (now <= pass) continue;
            pass = now - 1 + L;
            cnt++;
        }

        System.out.println(cnt);
    }
}