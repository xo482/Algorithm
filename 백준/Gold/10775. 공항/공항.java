import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int G, P;
    static int[] gate;

    public static void main(String[] args) throws IOException {
        G = Integer.parseInt(br.readLine());
        gate = new int[G+1];
        for (int i = 1; i <= G; i++) gate[i] = i;

        P = Integer.parseInt(br.readLine());
        int i = 0;
        for (i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            g = find(g);
            if (g == 0) break;
            gate[g]--;
        }
        System.out.println(i);
    }

    private static int find(int g) {
        if (gate[g] == g) return g;
        return gate[g] = find(gate[g]);
    }
}
