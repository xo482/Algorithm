import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int totalCnt = arr.length;
        int coupleCnt = 0;
        for (int i = 0; i < totalCnt; i++) {
            if (arr[i] == 'L') {
                coupleCnt++;
                i++;
            }
        }

        int answer;
        if (coupleCnt != 0) {
            answer = totalCnt - coupleCnt + 1;
        } else {
            answer = totalCnt;
        }

        System.out.println(answer);
    }
}