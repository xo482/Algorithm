import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, C;
    static int min = Integer.MAX_VALUE, max = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            list.add(number);

            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        Collections.sort(list);

        int mid = 0;
        int start = 1;
        int end = max - min + 1;

        while (start < end) {
            mid = (start + end) / 2;
//            System.out.print("start = " + start);
//            System.out.print(", end = " + end);
//            System.out.println(", mid = " + mid);

            int now = list.get(0);
            int cnt = 1;
            boolean flag = false;

            for (int i = 1; i < list.size(); i++) {

                int next = list.get(i);
                if (next - now >= mid) {
                    now = next;
                    cnt++;
                }

                if (cnt == C) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                start = mid + 1;
            } else {
                end = mid;
                if (start == end) {
                    mid -= 1;
                }
            }
        }


        System.out.println(mid);
    }
}