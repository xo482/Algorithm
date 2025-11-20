import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static Map<Character, Set<Character>> child = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            st.nextToken();
            char c = st.nextToken().charAt(0);
            
            if (p == c) continue;
            if (!child.containsKey(p)) child.put(p, new TreeSet<>());
            child.get(p).add(c);
        }

        for (char p : child.keySet()) {
            Set<Character> set = new TreeSet<>();
            tracking(p, p ,set);
            child.get(p).addAll(set);
        }

        int cnt = 0;
        for (char p : child.keySet()) {
            for (char c : child.get(p)) {
                cnt++;
                sb.append(p).append(" => ").append(c).append('\n');
            }
        }

        System.out.print(cnt + "\n" + sb);
    }

    private static void tracking(char root, char p, Set<Character> set) {
        if (!child.containsKey(p)) return;
        
        for (char c : child.get(p)) {
            if (root == c) continue;
            if (set.contains(c)) continue;
            
            set.add(c);
            tracking(root, c, set);
        }
    }
}
