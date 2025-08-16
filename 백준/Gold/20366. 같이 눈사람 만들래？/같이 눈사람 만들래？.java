import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] list;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int elsa = list[i] + list[j];

                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) continue;
//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
//                    System.out.println("k = " + k);
                    int anna_head = list[k];

                    int start = k;
                    int end = N;
                    while (start + 1 < end) {
                        int mid = (start + end) / 2;
                        int anna_body = list[mid];
                        int test_anna = anna_head + anna_body;

                        if (elsa < test_anna) {
                            end = mid;
                        }
                        else {
                            start = mid;
                        }
                    }

                    if (start == i || start == j || start == k) {
                        for (int l = -2; l < 3; l++) {
                            if (start+l == i || start+l == j || start+l == k) continue;
                            if (start+l < 0 || start+l >= N) continue;
//                            System.out.println("Math.abs(elsa - (list[start+l] + anna_head)) = " + Math.abs(elsa - (list[start + l] + anna_head)));
                            answer = Math.min(answer, Math.abs(elsa - (list[start+l] + anna_head)));
                        }
                    }
                    else {
//                        System.out.println("Math.abs(elsa - (list[start] + anna_head)) = " + Math.abs(elsa - (list[start] + anna_head)));
                        answer = Math.min(answer, Math.abs(elsa - (list[start] + anna_head)));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}