import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(i, str);
            map2.put(str, i);
        }

        while (M-- > 0) {
            String str = br.readLine();
            if (map2.containsKey(str)) sb.append(map2.get(str)).append("\n");
            else sb.append(map.get(Integer.parseInt(str))).append("\n");
        }
        System.out.print(sb.toString());
    }
}