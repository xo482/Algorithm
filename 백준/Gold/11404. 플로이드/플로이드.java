import java.io.*;
import java.util.*;

public class Main {

    static int cities;
    static int buses;
    static int[][] busList;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cities = Integer.parseInt(br.readLine());
        buses = Integer.parseInt(br.readLine());
        busList = new int[cities][cities];
        check = new boolean[cities][cities];

        // init
        StringTokenizer st = null;
        for (int i = 0; i < buses; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if (check[y][x]) {
                if (busList[y][x] > cost) {
                    busList[y][x] = cost;
                }
            } else {
                busList[y][x] = cost;
                check[y][x] = true;
            }
        }

        // logic
        for (int x = 0; x < cities; x++) {
            for (int i = 0; i < cities; i++) {
                for (int j = 0; j < cities; j++) {
                    if (check[i][j]) {
                        function(i, j);
                    }
                }
            }
        }

        for (int[] ints : busList) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    private static void function(int i, int j) {
        for (int k = 0; k <cities; k++) {
            if (check[j][k] && (i!=k)) {
                if (check[i][k]){
                    busList[i][k] = Math.min(busList[i][k], busList[i][j] + busList[j][k]);
                } else {
                    busList[i][k] = busList[i][j] + busList[j][k];
                    check[i][k] = true;
                }
            }
        }
    }
}