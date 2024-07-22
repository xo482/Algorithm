import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = N / 5 + 1;
        int sum = 0;
        boolean flag = false;

        while (i-- > 0)
            if ((N - (5 * i)) % 3 == 0) {
                flag = true;
                break;
            }

        if (flag) {
            sum = i;
            sum += (N - (5 * i)) / 3;
            System.out.print(sum);
        } else System.out.print(-1);

    }
}