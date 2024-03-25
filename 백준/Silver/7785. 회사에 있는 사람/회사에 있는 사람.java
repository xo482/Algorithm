import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, String> my = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            if (s[1].equals("leave")) my.remove(s[0]);
            else my.put(s[0], s[1]);
        }

        List<String> list = my.keySet().stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                })
                .collect(Collectors.toList());

        for (String s : list)
            sb.append(s).append("\n");

        System.out.print(sb);
    }
}