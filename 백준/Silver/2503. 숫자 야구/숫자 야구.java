import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[][] question = new int[N][3];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            question[i][0] = Integer.parseInt(st.nextToken());
            question[i][1] = Integer.parseInt(st.nextToken());
            question[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 123; i <= 987; i++) {
            char[] charArray = String.valueOf(i).toCharArray();
            if (charArray[0] == '0' || charArray[1] == '0' || charArray[2] == '0') continue;
            if (charArray[0] == charArray[1] || charArray[0] == charArray[2] ||charArray[1] == charArray[2]) continue;

            list.add(i);
        }

        while(!list.isEmpty()) {
            int num = list.removeFirst();
            char[] numList = String.valueOf(num).toCharArray();
            char[] testList;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                testList = String.valueOf(question[i][0]).toCharArray();
                int strike = 0;
                int ball = 0;
                for (int j = 0; j < 3; j++) {
                    if (numList[j] == testList[j]) strike++;
                    if (numList[j] != testList[j] && (numList[j] == testList[(j+1) % 3] || numList[j] == testList[(j+2) % 3])) ball++;
                }
                if (strike != question[i][1] || ball != question[i][2]){ flag = true; break;}

            }
            if (!flag) cnt++;
        }

        System.out.print(cnt);
    }
}
