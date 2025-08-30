import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException{
        for (int i = 1; i < 101; i++) dp[i] = i;
        
        for (int i = 1; i < 101; i++)
            for (int j = i+3; j < 101; j++)
                dp[j] = Math.max(dp[j], dp[i]*(j-(i+1)));
        
        System.out.print(dp[Integer.parseInt(br.readLine())]);
    }
}

