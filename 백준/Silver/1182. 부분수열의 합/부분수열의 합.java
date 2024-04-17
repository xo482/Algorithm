import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int S;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) 
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 1<<N; i++) {
            ArrayList<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < N; j++)
                if ((i & (1 << j)) != 0)
                    subSet.add(arr[j]);

            int sum = 0;
            for (Integer integer : subSet) sum += integer;
            if (sum == S && !subSet.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}