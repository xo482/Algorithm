import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Node[1000001];
        for (int i = 0; i < 1000001; i++) {
            arr[i] = new Node(-1,-1);
        }

        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(strs[i]);
            int pre = Integer.parseInt(strs[(i-1 + N) % N]);
            int nxt = Integer.parseInt(strs[(i+1) % N]);
            arr[now].pre = pre;
            arr[now].nxt = nxt;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if (com.equals("BN")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = arr[a].nxt;

                sb.append(c);
                arr[c].pre = b;
                arr[b].nxt = c;
                arr[b].pre = a;
                arr[a].nxt = b;
            }
            if (com.equals("BP")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = arr[a].pre;

                sb.append(c);
                arr[c].nxt = b;
                arr[b].pre = c;
                arr[b].nxt = a;
                arr[a].pre = b;
            }
            if (com.equals("CN")) {
                int a = Integer.parseInt(st.nextToken());
                int b = arr[a].nxt;
                int c = arr[b].nxt;

                sb.append(b);
                arr[a].nxt = c;
                arr[c].pre = a;
            }
            if (com.equals("CP")) {
                int a = Integer.parseInt(st.nextToken());
                int b = arr[a].pre;
                int c = arr[b].pre;

                sb.append(b);
                arr[a].pre = c;
                arr[c].nxt = a;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int pre, nxt;

        public Node(int pre, int nxt) {
            this.pre = pre;
            this.nxt = nxt;
        }
    }
}