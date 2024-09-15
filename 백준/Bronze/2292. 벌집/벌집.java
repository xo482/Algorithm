import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static double N;

    public static void main(String[] args) throws IOException {
        N = Double.parseDouble(br.readLine());
        N = (N-1) / 6;

        int cnt = 0;
        int sum = 0;

        while (sum < N) sum += ++cnt;
        
        System.out.println(cnt+1);
    }
}
// 1 7 19 37 61...
// 0 6 18 36 60...
// 0 1 3 6 10... 배수
// 1더하기 2더하기 3더하기 4더하기...