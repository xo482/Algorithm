import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[] numbers = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        // init
        for (int i = 0; i < N; i++) {
            list[i] = numbers[i] = Integer.parseInt(st.nextToken());
        }

        // sorting
        Arrays.sort(list);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(list[i])) {
                map.put(list[i], cnt++);
            }
        }

        // print
        for (int n : numbers) {
            sb.append(map.get(n)).append(" ");
        }
        System.out.print(sb);
    }
}
