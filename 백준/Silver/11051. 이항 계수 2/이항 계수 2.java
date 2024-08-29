import java.io.*;

public class Main {
    static long dp[][] = new long [1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //(n/k)는 nck
        //ncr = n-1cr + n-1cr-1

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long result = Combination(N, K);
        System.out.println(result);
    }
    static long Combination(int n,int r){
        int MOD = 10007;
        if(dp[n][r]>0){
            return dp[n][r];
        }else if(n==r || r==0){
            return dp[n][r] = 1;
        }else{
            return dp[n][r]=(Combination(n-1,r) + Combination(n-1,r-1)) % MOD;
        }
    }
}
