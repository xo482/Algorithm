import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static boolean[] list = new boolean[1001];

    public static void main(String[] args) throws IOException {

        list[0] = list[1] = true;
        for (int i = 2; i < 1001; i++) {
            if (!list[i]) {
                for (int j = i*i; j < 1001; j+=i)
                    list[j] = true;
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (!list[Integer.parseInt(st.nextToken())])
                cnt++;

        System.out.println(cnt);
    }
}