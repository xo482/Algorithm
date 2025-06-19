import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            Node root = new Node();
            N = Integer.parseInt(br.readLine());
            List<String> temp = new ArrayList<>();
            while (N-- > 0) {
                temp.add(br.readLine());
            }
            Collections.sort(temp);
            Collections.reverse(temp);

            boolean flag = false;
            for (String line : temp) {
                String[] split = line.split("");
                Node now = root;
                flag = false;
                for (String s : split) {
                    int key = Integer.parseInt(s);
                    if (!now.map.containsKey(key)) {
                        now.map.put(key, new Node());
                        flag = true;
                    }
                    now = now.map.get(key);
                }
                if (!flag) break;
            }

            if (!flag) sb.append("NO\n");
            else sb.append("YES\n");

        }
        System.out.print(sb);
    }

    static class Node {
        Map<Integer, Node> map = new HashMap<>();
    }
}
