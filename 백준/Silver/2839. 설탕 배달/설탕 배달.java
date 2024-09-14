import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int answer = -1;
        int start = N / 5;

        while (start > -1) {
            if ((N - start * 5) % 3 == 0) {
                answer = start + ((N - start * 5) / 3);
                break;
            }
            start--;
        }
        
        System.out.println(answer);
    }
}