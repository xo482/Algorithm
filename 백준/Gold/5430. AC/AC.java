import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int n;
    static char[] p;
    static ArrayDeque<Integer> Q;
    static boolean flag;
    static boolean R;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Q = new ArrayDeque<>();
            p = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            if (line.length() != 2){
                String[] split = line.substring(1, line.length() - 1).split(",");
                for (String s : split)
                    Q.add(Integer.parseInt(s));
            }

            flag = false;
            R = false; // false는 앞에서 true는 뒤에서
            for (char c : p) {
                if (c == 'R')
                    R = !R;
                if (c == 'D') {
                    if (Q.isEmpty()) {flag = true;break;}
                    if (!R) Q.removeFirst();
                    if (R) Q.removeLast();
                }

            }

            if (flag) sb.append("error");
            else {
                if (Q.isEmpty()) sb.append("[]");
                else{
                    if (!R) {
                        sb.append("[").append(Q.removeFirst());
                        for (int i : Q) sb.append(",").append(i);
                        sb.append("]");
                    } else {
                        sb.append("[").append(Q.removeLast());
                        while(!Q.isEmpty()) sb.append(",").append(Q.removeLast());
                        sb.append("]");
                    }
                }
            }
            if (T != 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
