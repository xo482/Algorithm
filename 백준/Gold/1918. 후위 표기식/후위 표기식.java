import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Character> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {sb.append(c); continue;}
            if (c == '(') {stack.addLast(c); continue;}
            if (c == ')') {
                while (!stack.isEmpty()) {
                    char operator = stack.removeLast();
                    if (operator == '(') break;
                    sb.append(operator);
                }
                continue;
            }

            while (!stack.isEmpty()) {
                if (precedence(stack.getLast()) < precedence(c)) break;
                sb.append(stack.removeLast());
            }
            stack.addLast(c);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        System.out.println(sb);
    }

    public static int precedence(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0; //스택 안에는 '('도 들어올 수 있다. 하지만 '('는 꺼내져서는 안되기 때문에 제일 낮은 값을 반환하도록 한다.
    }
}
