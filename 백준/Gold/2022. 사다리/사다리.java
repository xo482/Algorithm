import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static double x, y, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        double start = 0;
        double end = Math.max(x, y) + 1;
        while (start + 0.0001 < end) {
            double mid = (start + end) / 2;
            double hi = getHigh(mid);

            if (hi >= c) start = mid;
            else end = mid;
        }

        System.out.println(start);
    }

    private static double getHigh(double mid) {
        double gi1 = Math.sqrt(y * y - mid * mid) / mid;
        double yjur1 = 0;

        double gi2 = Math.sqrt(x * x - mid * mid) / mid * (-1);
        double yjur2 = gi2 * mid * (-1);

        double nx = (yjur1 - yjur2) / (gi1 - gi2) * (-1);
        double ny = gi1 * nx;

        return ny;
    }
    //(0,0) , (mid, 루트 y^2 + mid^2);
    //(0,루트 x^2 + mid^2), (mid,0);
}