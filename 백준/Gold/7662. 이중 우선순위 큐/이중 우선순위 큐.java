import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (N-- > 0) {
                String[] s = br.readLine().split(" ");
                int num = Integer.parseInt(s[1]);
                if (s[0].equals("I")){
                    if (map.containsKey(num))
                        map.put(num, map.get(num)+1);
                    else
                        map.put(num, 0);
                }
                else if (!map.isEmpty()) {
                    if (num == -1) {
                        Integer i = map.firstKey();

                        if (map.get(i) != 0)
                            map.put(i, map.get(i) - 1);
                        else
                            map.remove(i);
                    } else {
                        Integer i = map.lastKey();

                        if (map.get(i) != 0)
                            map.put(i, map.get(i) - 1);
                        else
                            map.remove(i);
                    }
                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}