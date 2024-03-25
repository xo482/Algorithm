import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                cnt++;
                list.add(name);
            }
        }

        Collections.sort(list);

        sb.append(cnt).append("\n");
        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.print(sb);
    }
}