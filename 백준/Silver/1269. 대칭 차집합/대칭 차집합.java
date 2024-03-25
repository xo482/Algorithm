import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        String[] arr1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map.put(arr1[i], 0);
        }

        int cnt = 0;
        String[] arr2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (map.containsKey(arr2[i])) {
                cnt++;
            }
        }


        System.out.print(N+M-2*cnt);
    }
}