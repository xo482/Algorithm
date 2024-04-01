import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Map<String, Node> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            map.put(s, new Node(s));
            map.get(s).left = st.nextToken();
            map.get(s).right = st.nextToken();
        }

        // 전위 탐색
        map.get("A").preorder();
        System.out.println(sb);

        sb = new StringBuilder();
        map.get("A").inorder();
        System.out.println(sb);

        sb = new StringBuilder();
        map.get("A").postorder();
        System.out.println(sb);
    }

    static class Node {
        public String name;
        public String left = null;
        public String right = null;

        public Node(String name) {
            this.name = name;
        }

        public void preorder() {
            sb.append(name);
            if (!left.equals(".")) map.get(left).preorder();
            if (!right.equals(".")) map.get(right).preorder();
        }

        public void inorder() {
            if (!left.equals(".")) map.get(left).inorder();
            sb.append(name);
            if (!right.equals(".")) map.get(right).inorder();
        }

        public void postorder() {
            if (!left.equals(".")) map.get(left).postorder();
            if (!right.equals(".")) map.get(right).postorder();
            sb.append(name);
        }
    }

}
