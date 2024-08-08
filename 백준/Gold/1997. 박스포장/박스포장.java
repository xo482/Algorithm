import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] pan;
    static int[][] box;
    static int n,w,b, h;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken()); // 장식 판의 종류
        w = Integer.parseInt(st.nextToken()); // 박스 너비
        b = Integer.parseInt(st.nextToken()); // 박스 높이
        box = new int[b][w];

        while (n-- > 0) {
            h = Integer.parseInt(br.readLine());
            pan = new int[h][w];

            for (int i = 0; i < h; i++) {
                String[] split = br.readLine().split("");

                for (int j = 0; j < w; j++)
                    if (split[j].equals("X")) pan[i][j] = 1;

            }

            go();

        }

        boolean sex = false;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < w; j++) {
                if (box[i][j] == 1) {
                    sb.append(b - i).append(" ");
                    sex = true;
                    break;
                }
            }
            if (sex) break;

        }

        System.out.println(sb);
    }

    private static void go() {
        boolean finalFlag = false; // 뒀는가 못 뒀는가

        for (int height = b-h; height >= 0; height--) {

            boolean flag = true;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if ((pan[i][j] == 1) && (box[height + i ][j] == 1)){
                        flag = false; break;}
                }
                if (!flag) break;
            }

            if (flag) {
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        box[height + i][j] = pan[i][j];
                    }
                }

                finalFlag = true;
                break;
            }
        }

        if (!finalFlag) {

            boolean sex = false;
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < w; j++) {
                    if (box[i][j] == 1) {
                        sb.append(b - i).append(" ");
                        sex = true;
                        break;
                    }
                }
                if (sex) break;

            }

            for (int i = 0; i < b; i++) {
                for (int j = 0; j < w; j++) {
                    box[i][j] = 0;
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    box[b - h + i][j] = pan[i][j];
                }
            }
        }

    }
}