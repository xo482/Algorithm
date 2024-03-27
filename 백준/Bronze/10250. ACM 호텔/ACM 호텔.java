import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int res=0;

        while(T-- > 0) {
            String[] str = br.readLine().split(" ");

            res = 0;
            int H = Integer.parseInt(str[0]); // 층수
            int W = Integer.parseInt(str[1]); // 층마다 방 수
            int N = Integer.parseInt(str[2]); // 번째

            int i = N / H;
            int j = N % H;


            if (j == 0) {
                res += i;
                res += (int) ((H) * Math.pow(10, 2));
            } else {
                res += i+1;
                res += (int) ((j) * Math.pow(10, 2));
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
