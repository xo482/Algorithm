import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Area[] areas = new Area[33];
    static int[] unit = new int[4];
    static int[] arr = new int[10];
    static int max = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) arr[i] = Integer.parseInt(st.nextToken());

        makeAreas();
        tracking(0, 0);
        System.out.println(max);
    }

    private static void makeAreas() {

        for (int i = 0; i < 21; i++) areas[i] = new Area(i + 1, i * 2);

        areas[21]= new Area(22, 13);
        areas[22]= new Area(23, 16);
        areas[23]= new Area(29, 19);

        areas[24]= new Area(25, 22);
        areas[25]= new Area(29, 24);

        areas[26]= new Area(27, 28);
        areas[27]= new Area(28, 27);
        areas[28]= new Area(29, 26);

        areas[29]= new Area(30, 25);
        areas[30]= new Area(31, 30);
        areas[31]= new Area(20, 35);

        areas[20] = new Area(32, 40);
        areas[32]= new Area(-1, 0);
    }
    private static void tracking(int depth, int sum) {
        if (depth == 10) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int memory = unit[i];
            int value = move(i, arr[depth]);
            if (value == -1) continue;

            sum += value;
            tracking(depth+1, sum);
            sum -= value;

            unit[i] = memory;
        }
    }

    // 움직이고 움직인 곳의 값을 리턴해줌
    private static int move(int who, int how) {
        int now = unit[who];

        if (now == 5) { now = 21; how--; }
        if (now == 10) { now = 24; how--; }
        if (now == 15) { now = 26; how--; }

        while (how-- > 0) {
            if (now==32) break;
            now = areas[now].NXT;
        }

        // 다른 놈이랑 같은 자리
        for (int position : unit)
            if (now != 32 && position == now)
                return -1;

        unit[who] = now;
        return areas[now].value;
    }


    static class Area {
        int NXT;
        int value;

        public Area(int NXT, int value) {
            this.NXT = NXT;
            this.value = value;
        }
    }
}