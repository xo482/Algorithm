import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] me, you, arr;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        me = new int[N/2+1];
        you = new int[N/2+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i % 2 == 1) me[i / 2 + 1] = me[i / 2] + arr[i];
            if (i % 2 == 0) you[i / 2] = you[i / 2 - 1] + arr[i];
        }

        for (int i = 1; i <= N; i++) {
            // 내 턴일때 밑장 빼기 하면 해당 위치에서부터 내 패랑 상대 패가 바뀌는거랑 똑같음
            if (i % 2 == 1) max = Math.max(max, me[i / 2] + you[N / 2] - you[(i + 1) / 2 - 1]);

            // 상대 턴일때 밑장 빼기 하면 마지막장은 상대가 가지고 그거 제외한 나머지는 내가 먹음
            if (i % 2 == 0) max = Math.max(max, me[i / 2] + you[N / 2 - 1] - you[i / 2 - 1]);
        }
        System.out.println(Math.max(max, me[N / 2]));
    }
}