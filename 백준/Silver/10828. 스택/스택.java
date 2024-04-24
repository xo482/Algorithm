import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) stack.addLast(Integer.parseInt(st.nextToken()));

            if (command.equals("size")) sb.append(stack.size()).append("\n");
            if (command.equals("empty")) sb.append((stack.isEmpty())?1:0).append("\n");
            if (command.equals("pop")) {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.removeLast()).append("\n");
            }
            if (command.equals("top")) {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.getLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}