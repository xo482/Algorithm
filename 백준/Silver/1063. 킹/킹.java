import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int kingI;
    static int kingJ;
    static int rockI;
    static int rockJ;

    public static void main(String[] args) throws IOException {

        String[] split = br.readLine().split(" ");
        kingJ = split[0].charAt(0) - 'A';
        kingI = split[0].charAt(1) - '1';
        rockJ = split[1].charAt(0) - 'A';
        rockI = split[1].charAt(1) - '1';
        int N = Integer.parseInt(split[2]);

        while (N-- > 0) {
            String command = br.readLine();
            if (command.equals("R")) {
                move(0, 1);
            }
            else if (command.equals("L")) {
                move(0, -1);
            }
            else if (command.equals("T")) {
                move(1, 0);
            }
            else if (command.equals("B")) {
                move(-1, 0);
            }
            else if (command.equals("RB")) {
                move(-1, 1);
            }
            else if (command.equals("RT")) {
                move(1, 1);
            }
            else if (command.equals("LB")) {
                move(-1, -1);
            }
            else if (command.equals("LT")) {
                move(1, -1);
            }
        }

        System.out.print((char)(kingJ+65));
        System.out.println((kingI+1));
        System.out.print((char)(rockJ+65));
        System.out.println((rockI+1));
    }

    static void move(int i, int j) {
        if (kingI + i == rockI && kingJ + j == rockJ) {
            if (rockI + i >= 0 && rockJ + j >= 0 && rockI + i < 8 && rockJ + j < 8) {
                kingI += i;
                rockI += i;
                kingJ += j;
                rockJ += j;
            }
        } else {
            if (kingI + i >= 0 && kingJ + j >= 0 && kingI + i < 8 && kingJ + j < 8) {
                kingI += i;
                kingJ += j;
            }
        }
    }
}