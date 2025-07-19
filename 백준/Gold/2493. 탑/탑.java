import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] tops;
    static ArrayDeque<Node> stack = new ArrayDeque<Node>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        tops = new int[N];
        for (int i = 0; i < N; i++) tops[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.add(new Node(i, tops[i]));
                sb.append("0 ");
                continue;
            }


            while (!stack.isEmpty() && stack.getLast().high <= tops[i]) stack.removeLast();
            if (stack.isEmpty()) {
                stack.add(new Node(i, tops[i]));
                sb.append("0 ");
                continue;
            }

            sb.append(stack.getLast().idx + 1).append(" ");
            stack.add(new Node(i, tops[i]));
        }

        System.out.println(sb);
    }

    static class Node {
        int idx;
        int high;

        public Node(int idx, int high) {
            this.idx = idx;
            this.high = high;
        }
    }
}