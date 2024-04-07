import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N; // 배열의 길이
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        // init
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(i, 0);
        }

        for (int i = N-2; i >= 0; i--) {
            for (int j = i+1; j <N; j++) {
                if (arr[i] < arr[j] && map.get(i) < map.get(j)+1) map.put(i, map.get(j) + 1);
            }
        }

        int max = 0;
        for (Integer i : map.keySet()) {
            int val = map.get(i);
            if (max < val) max = val;
        }

        System.out.println(max + 1);
    }

}
