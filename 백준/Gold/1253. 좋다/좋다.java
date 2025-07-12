import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static long[] arr;
    static boolean[] good;
    static Map<Long, Integer> map = new HashMap<>();
    static Map<Long, Boolean> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        good = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map2.put(arr[i], false);
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                if (map2.get(arr[j])) continue;
                long diff = arr[j] - arr[i];
                int start = -1;
                int end = N;
                while (start + 1 < end) {
                    int mid = (start + end) / 2;
                    if (arr[mid] <= diff) start = mid;
                    else end = mid;
                }

                if (start != -1 && start != i && start != j && arr[start] == diff) {
//                    System.out.print("arr[i] = " + arr[i]);
//                    System.out.print(", arr[start] = " + arr[start]);
//                    System.out.println(", arr[j] = " + arr[j]);
                    map2.put(arr[j], true);
                }
            }
        }

        int ans = 0;
        for (Long key : map2.keySet()) {
            if (map2.get(key))
                ans += map.get(key);
//            System.out.print("key = " + key);
//            System.out.println(", ans = " + ans);
        }
        System.out.println(ans);
    }
}

