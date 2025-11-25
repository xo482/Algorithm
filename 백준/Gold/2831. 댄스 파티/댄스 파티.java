import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans = 0;
    static List<Integer> man_list_want_tall_woman = new ArrayList<>();
    static List<Integer> man_list_want_small_woman = new ArrayList<>();
    static List<Integer> woman_list_want_tall_man = new ArrayList<>();
    static List<Integer> woman_list_want_small_man = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int height = Integer.parseInt(st.nextToken());
            if (height > 0) man_list_want_tall_woman.add(height);
            if (height < 0) man_list_want_small_woman.add(-height);
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int height = Integer.parseInt(st.nextToken());
            if (height > 0) woman_list_want_tall_man.add(height);
            if (height < 0) woman_list_want_small_man.add(-height);
        }


        Collections.sort(man_list_want_tall_woman);
        Collections.sort(man_list_want_small_woman);
        Collections.sort(woman_list_want_tall_man);
        Collections.sort(woman_list_want_small_man);

        int man_idx = 0;
        int woman_idx = 0;
        int man_size = man_list_want_tall_woman.size();
        int woman_size = woman_list_want_small_man.size();
        while (man_idx < man_size && woman_idx < woman_size) {
            int man_h = man_list_want_tall_woman.get(man_idx);
            int woman_h = woman_list_want_small_man.get(woman_idx);

            if (man_h < woman_h) {
                man_idx++;
                woman_idx++;
                ans++;
                continue;
            }

            woman_idx++;
        }

        man_idx = 0;
        woman_idx = 0;
        man_size = man_list_want_small_woman.size();
        woman_size = woman_list_want_tall_man.size();
        while (man_idx < man_size && woman_idx < woman_size) {
            int man_h = man_list_want_small_woman.get(man_idx);
            int woman_h = woman_list_want_tall_man.get(woman_idx);

            if (man_h > woman_h) {
                man_idx++;
                woman_idx++;
                ans++;
                continue;
            }

            man_idx++;
        }

        System.out.println(ans);
    }
}