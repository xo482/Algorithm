import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Character> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        deque.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (deque.peekFirst() >= c) deque.addFirst(c);
            else deque.addLast(c);
        }
        for (char c : deque) sb.append(c);
        System.out.println(sb);
    }
}