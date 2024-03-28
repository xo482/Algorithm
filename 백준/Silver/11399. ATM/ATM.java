import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int N = Integer.parseInt(br.readLine()); // 줄 서 있는 사람의 수
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            sum += accumulate(i);
        }

        System.out.print(sum);
    }

    public static int accumulate(int index) {
        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
