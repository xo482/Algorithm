import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int[] field = new int[100_001];

        Q.addLast(N);

        while(!Q.isEmpty()) {
            int now = Q.removeFirst();
            if(now+1 < 100_001 &&
                    (field[now+1] == 0 || (field[now+1] > field[now]+1 && field[now+1] != 0))) {
                field[now+1] = field[now]+1;
                Q.addLast(now+1);
            }
            if(now-1 > -1 &&
                    (field[now-1] == 0 || (field[now-1] > field[now]+1 && field[now-1] != 0))) {
                field[now-1] = field[now]+1;
                Q.addLast(now-1);
            }
            if(now*2 < 100_001 &&
                    (field[now*2] == 0 || (field[now*2] > field[now]+1 && field[now*2] != 0))) {
                field[now*2] = field[now]+1;
                Q.addLast(now*2);
            }
        }

        if (M==N) System.out.println(0);
        else System.out.print(field[M]);
    }
}
