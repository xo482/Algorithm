import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<Integer, Long> map = new HashMap<>();
    static boolean[] first_exist = new boolean[10];
    static List<long[]> list = new ArrayList<>();
    static PriorityQueue<Integer> numQ = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) numQ.add(i);
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            char[] chars = br.readLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == 0) first_exist[chars[i] - 'A'] = true;

                long cost = (long) Math.pow(10, chars.length - i - 1);
                map.put(chars[i] - 'A', map.getOrDefault(chars[i] - 'A', 0L) + cost);
            }
        }

        for (int key : map.keySet()) list.add(new long[]{key, map.get(key)});
        
        
        
        if (list.size() != 10) {
            list.sort(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    if (o1[1] == o2[1]) return 0;
                    return o1[1] - o2[1] < 0 ? 1 : -1;
                }
            });

            int value = 9;
            long sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i)[1] * value;
                value--;
            }

            System.out.println(sum);
            return;
        }




        list.sort(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] == o2[1]) return 0;
                return o1[1] - o2[1] > 0 ? 1 : -1;
            }
        });
        
        int idx = 0;
        long sum = 0;
        while (!list.isEmpty()) {
            long[] now = list.get(idx);
            int now_number = numQ.poll();
            if (now_number == 0 && first_exist[(int) now[0]]) {
                idx++;
                numQ.add(now_number);
                continue;
            }

            sum += now[1] * now_number;
            list.remove(idx);
            idx = 0;
        }

        System.out.println(sum);
    }
}