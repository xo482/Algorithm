import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a, b;
    static boolean[] isPrime;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        int maxSqrt = (int) Math.sqrt(b);
        isPrime = new boolean[maxSqrt + 1];

        for(int i = 2; i * i <= maxSqrt; i++){
            if(isPrime[i]) continue;
            for(int j = i * i; j <= maxSqrt; j += i) isPrime[j] = true;
        }

        long cnt = 0;
        for(int i=2; i<=maxSqrt; i++){
            if(isPrime[i]) continue;
            long val = (long) i * i;
            while(val <= b){
                if(val >= a) cnt++;
                if(val > b / i) break;
                
                val *= i;
            }
        }
        System.out.println(cnt);
    }
}