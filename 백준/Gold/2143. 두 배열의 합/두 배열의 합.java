import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[] arrN, arrM;
    static int[] dpN, dpM;
    static Map<Integer, Integer> map = new HashMap<>();
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        dpN = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arrN[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        dpM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arrM[i] = Integer.parseInt(st.nextToken());

        dpN[0] = arrN[0];
        for (int i = 1; i < N; i++) dpN[i] = dpN[i-1] + arrN[i];
        dpM[0] = arrM[0];
        for (int i = 1; i < M; i++) dpM[i] = dpM[i-1] + arrM[i];

        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                int key = dpM[j] - dpM[i] + arrM[i];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int now = dpN[j] - dpN[i] + arrN[i];
                int key = T-now;

                if (map.containsKey(key)) {
                    answer += map.get(key);
                }
            }
        }

        System.out.println(answer);
    }

}