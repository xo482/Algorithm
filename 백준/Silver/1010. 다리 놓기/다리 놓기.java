import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    
    public static BigInteger factorial(int n, int m) {
        BigInteger result = BigInteger.ONE;
        for(int i=n+1;i<=m;i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            BigInteger a = factorial(n,m);
            BigInteger b = factorial(1,m-n);
            BigInteger result = a.divide(b);
            
            System.out.println(result);
        }
    }
}