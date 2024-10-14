import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, total, max = 0;
    static int[] request;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        request = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            request[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, request[i]);
        }

        total = Integer.parseInt(br.readLine());

        int start = 1;
        int end = max;
        while (start <= end) {
            int mid = (start + end) / 2; // 상한액 설정

//            System.out.print("start = " + start);
//            System.out.print(", end = " + end);
//            System.out.println(", mid = " + mid);

            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (request[i] <= mid) sum += request[i];
                else sum += mid;
            }


            if (start == end) {
                if (sum > total) end -= 1;
                break;
            }


            if (sum < total) start = mid + 1;
            else end = mid;
        }

        System.out.println(end);
    }
}