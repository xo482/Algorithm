import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[] list, explosionStr;
    static ArrayList<Character> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        list = br.readLine().toCharArray();
        explosionStr = br.readLine().toCharArray();

        for (char c : list) {
            stack.add(c);
            pop();
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            for (char c : stack) sb.append(c);
            System.out.println(sb);
        }
    }

    private static void pop() {
        int len = stack.size();
        if (len < explosionStr.length) return;

        boolean flag = false;
        for (int i = 0; i < explosionStr.length; i++) {
            if (stack.get(len + i - explosionStr.length) != explosionStr[i]){ flag = true; break;}
        }

        if (!flag)
            for (int i = 0; i < explosionStr.length; i++)
                stack.remove(stack.size() - 1);
    }
}