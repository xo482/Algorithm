import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N =sc.nextInt();
            int[] pillars = new int[N];
            int answer = 500001;

            for (int i = 0; i < N; i++) pillars[i] = sc.nextInt();
            Map<Integer, Integer>[] list = new Map[N];
            for (int i = 0; i < N; i++) {
                list[i] = new HashMap<>();
                initMap(pillars[i], 0, list[i]);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) set.addAll(list[i].keySet());

            for (int key : set) {
                int sum = 0;
                boolean flag = false;

                for (int i = 0; i < N; i++) {
                    if (!list[i].containsKey(key)) {
                        flag = true;
                        break;
                    }

                    sum += list[i].get(key);
                }

                if (flag) continue;
                answer = Math.min(answer, sum);
            }

            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    private static void initMap(int pillar, int cnt, Map<Integer, Integer> map) {
        if (pillar <= 0) return;
        if (map.containsKey(pillar) && map.get(pillar) <= cnt) return;

        map.put(pillar, Math.min(cnt, map.getOrDefault(pillar, 500001)));

        int left = pillar / 2;
        int right = pillar - left;
        initMap(left, cnt + 1, map);
        initMap(right, cnt + 1, map);
    }
}