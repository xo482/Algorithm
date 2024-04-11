import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // --> 앞보다 크면 증가
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }

        // <-- 뒤보다 크면 증가
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            left[i] += right[i];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] > max) max = left[i];
        }

        System.out.println(max+1);
    }
}