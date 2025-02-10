import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] sawtooth = new int[4][8];
    static int[] L = new int[]{6, 6, 6, 6};
    static int[] R = new int[]{2, 2, 2, 2};

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++)
                sawtooth[i][j] = charArray[j] - '0';
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int who = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken());

            tracking(who, direction, 0);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            int idx = Math.floorMod(R[i] - 2, 8);
            if (sawtooth[i][idx] == 1)
                score += (int) Math.pow(2, i);
        }
        System.out.println(score);
    }

    // source가 1이면 왼쪽에서 오른쪽으로 넘어옴, source가 -1이면 오른쪽에서 왼쪽으로 넘어옴
    static private void tracking(int who, int direction, int source) {

        if (who != 0 && sawtooth[who][L[who]] != sawtooth[who-1][R[who-1]])
            if (source == 0 || source == -1)
                tracking(who - 1, direction * (-1), -1);

        if (who != 3 && sawtooth[who][R[who]] != sawtooth[who+1][L[who+1]])
            if (source == 0 || source == 1)
                tracking(who + 1, direction * (-1), 1);


        L[who] = Math.floorMod(L[who] - direction, 8);
        R[who] = Math.floorMod(R[who] - direction, 8);
    }
}