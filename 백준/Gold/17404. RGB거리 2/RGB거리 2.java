import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static House[] house;
    static int INF = 2_000_001;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        house = new House[N+1];
        house[0] = new House(0, 0, 0);

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            house[i] = new House(R,G,B);
        }


//        System.out.println("solution('R') = " + solution('R'));
//        System.out.println("solution('G') = " + solution('G'));
//        System.out.println("solution('B') = " + solution('B'));


        int min = Math.min(solution('R'), Math.min(solution('G'), solution('B')));
        System.out.println(min);
    }

    private static int solution(char r) {
        House[] temp = new House[N + 1];

        if (r == 'R') {
            temp[2] = new House(INF, house[1].R + house[2].G, house[1].R + house[2].B);
        }
        if (r == 'G') {
            temp[2] = new House(house[1].G + house[2].R, INF, house[1].G + house[2].B);
        }
        if (r == 'B') {
            temp[2] = new House(house[1].B + house[2].R, house[1].B + house[2].G, INF);
        }

        for (int i = 3; i <N+1; i++) {
            temp[i] = new House(house[i].R + Math.min(temp[i - 1].G, temp[i - 1].B), house[i].G + Math.min(temp[i - 1].R, temp[i - 1].B),
                    house[i].B + Math.min(temp[i - 1].R, temp[i - 1].G));
        }

        if (r == 'R') {
            temp[N].R = INF;
        }
        if (r == 'G') {
            temp[N].G = INF;
        }
        if (r == 'B') {
            temp[N].B = INF;
        }

        return Math.min(temp[N].R, Math.min(temp[N].G, temp[N].B));
    }


    static class House {
        int R, G, B;

        public House(int r, int g, int b) {
            R = r;
            G = g;
            B = b;
        }
    }
}