import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int MAX = 246912;
    static boolean[] isPrime = new boolean[MAX];
    
    public static void main(String[] args) throws IOException {
        
        isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if(isPrime[i]) continue;
            for (int j = i * i; j < MAX; j += i) {
                if (!isPrime[j]) isPrime[j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (i >= MAX) continue;
                if (!isPrime[i]) cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

}