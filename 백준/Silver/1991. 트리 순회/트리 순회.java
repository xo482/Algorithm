import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Map<Character, Character[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char P = line.charAt(0);
            char L = line.charAt(2);
            char R = line.charAt(4);

            map.put(P, new Character[]{L, R});
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        sb.append("\n");

        System.out.println(sb);
    }

    private static void preorder(char node) {
        sb.append(node);
        Character[] childArr = map.get(node);
        if (childArr[0] != '.') preorder(childArr[0]);
        if (childArr[1] != '.') preorder(childArr[1]);
    }

    private static void inorder(char node) {
        Character[] childArr = map.get(node);
        if (childArr[0] != '.') inorder(childArr[0]);
        sb.append(node);
        if (childArr[1] != '.') inorder(childArr[1]);
    }

    private static void postorder(char node) {
        Character[] childArr = map.get(node);
        if (childArr[0] != '.') postorder(childArr[0]);
        if (childArr[1] != '.') postorder(childArr[1]);
        sb.append(node);
    }
}