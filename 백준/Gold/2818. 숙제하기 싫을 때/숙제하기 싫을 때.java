import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R;
    static long C, total = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        Dice dice = new Dice(4, 3, 1, 6, 2, 5);

        for (int i = 0; i < R; i++) {
            total += dice.calculate(i);
            dice.shiftDown();
        }

        System.out.println(total);
    }

    static class Dice {
        long left, right, top, bottom, front, back;

        public Dice(long left, long right, long top, long bottom, long front, long back) {
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
            this.front = front;
            this.back = back;
        }


        public long calculate(int i) {
            long q = C / 4;
            long r = C % 4;

            long sum = 14 * q;
            if (i % 2 == 0) {
                while (r-- > 0) {
                    sum += this.top;
                    this.shiftRight();
                }
                this.shiftLeft();
            }
            if (i % 2 == 1) {
                while (r-- > 0) {
                    sum += this.top;
                    this.shiftLeft();
                }
                this.shiftRight();
            }

            return sum;
        }

        public void shiftRight() {
            long temp = top;
            top = left;
            left = bottom;
            bottom = right;
            right = temp;
        }

        public void shiftLeft() {
            long temp = top;
            top = right;
            right = bottom;
            bottom = left;
            left = temp;
        }

        public void shiftDown() {
            long temp = top;
            top = back;
            back = bottom;
            bottom = front;
            front = temp;
        }
    }
}