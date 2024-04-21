import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String calculation = st.nextToken();
            if (calculation.equals("all")) {
                list.clear();
                for (int i = 1; i <=20; i++) {
                    list.add(i);
                }
            } else if (calculation.equals("empty")) {
                list.clear();
            } else {
                int val = Integer.parseInt(st.nextToken());
                if (!list.contains(val) && calculation.equals("add")) {
                    list.add(val);
                } else if (list.contains(val) && calculation.equals("remove")) {
                    list.remove((Integer) val);
                } else if (calculation.equals("check")) {
                    if (list.contains(val)) sb.append("1\n");
                    else sb.append("0\n");
                } else if (calculation.equals("toggle")) {
                    if (list.contains(val)) list.remove((Integer) val);
                    else list.add(val);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
