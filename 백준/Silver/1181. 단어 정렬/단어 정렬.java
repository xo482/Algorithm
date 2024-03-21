import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] arr = set.toArray(new String[0]);

        Arrays.sort(arr,
                (s1, s2) ->{
                    if (s1.length() == s2.length())
                        return s1.compareTo(s2);
                    else
                        return s1.length() - s2.length();
                });

        for (String str : arr) {
            sb.append(str).append("\n");
        }

        System.out.print(sb);
    }
}
