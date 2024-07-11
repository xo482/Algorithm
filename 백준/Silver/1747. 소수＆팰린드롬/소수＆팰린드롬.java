import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.print(2);
            return;
        }
        while (true) {
            if (isPalindromeNumber(N) && isPrime(N)) {
                System.out.print(N);
                break;
            }
            N++;
        }
    }

    private static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;

        return true;
    }

    private static boolean isPalindromeNumber(int num) {
        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len / 2; i++)
            if (chars[i] != chars[len - 1 - i]) return false;

        return true;
    }
}