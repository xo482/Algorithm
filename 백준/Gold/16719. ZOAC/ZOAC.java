import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, PriorityQueue<Node>> map = new HashMap<>();
    static char[] chars;
    static boolean[] visited;
    static int len;

    public static void main(String[] args) throws Exception {
        chars = br.readLine().toCharArray();
        len = chars.length;
        visited = new boolean[len];


        for (int key = -1; key < len; key++) {
            for (int i = key+1; i < len; i++) {
                if (!map.containsKey(key))
                    map.put(key, new PriorityQueue<>());

                map.get(key).add(new Node(i, chars[i]));
            }
        }

        tracking(-1);
        System.out.println(sb);
    }

    private static void tracking(int key) {
        PriorityQueue<Node> Q = map.get(key);
        if (key != -1) sb.append(makeString()).append("\n");
        if (key == len-1) return;

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (visited[now.idx]) continue;

            visited[now.idx] = true;


            tracking(now.idx);
        }
    }

    private static String makeString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (visited[i]){
                sb2.append(chars[i]);
            }
        }
        return sb2.toString();
    }


    static class Node implements Comparable<Node> {
        int idx;
        char c;

        public Node(int idx, char c) {
            this.idx = idx;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            if (this.c == o.c) return this.idx - o.idx;
            return this.c - o.c;
        }
    }
}
