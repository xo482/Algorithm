import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> my = new HashMap<>();
        for (String s : br.readLine().split(" ")) {
            my.put(s, 0);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (M-- > 0) {
            if(my.containsKey(st.nextToken())) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.print(sb);
    }
}