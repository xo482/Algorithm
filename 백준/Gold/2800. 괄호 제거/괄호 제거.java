import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String line;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static Set<String> set = new TreeSet<>();
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        line = br.readLine();
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (c == '(') stack.addLast(i);
            if (c == ')') {
                int j = stack.removeLast();
                list.add(new int[]{i, j});
            }
        }

        int size = list.size();
        int loop = (int) Math.pow(2, size);
        for (int i = 1; i < loop; i++) {
            char[] chars = line.toCharArray();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    int[] now = list.get(j);
                    chars[now[0]] = ' ';
                    chars[now[1]] = ' ';
                }
            }
            StringBuilder ssb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (chars[j] == ' ') continue;
                ssb.append(chars[j]);
            }
            set.add(ssb.toString());
        }
        for (String poll : set){
            sb.append(poll).append("\n");
        }
        System.out.println(sb);
    }
}