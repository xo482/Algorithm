import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            double Ax = Double.parseDouble(st.nextToken());
            double Ay = Double.parseDouble(st.nextToken());
            double Ar = Double.parseDouble(st.nextToken());
            double Bx = Double.parseDouble(st.nextToken());
            double By = Double.parseDouble(st.nextToken());
            double Br = Double.parseDouble(st.nextToken());
            double len = Ar + Br;
            double betweenLength = Math.sqrt(Math.pow((Ax - Bx), 2) + Math.pow((Ay - By), 2));

            if(Ax == Bx && Ay == By && Ar == Br) System.out.println(-1);
            else if (betweenLength+Ar < Br || betweenLength+Br < Ar) System.out.println(0);
            else if (betweenLength+Ar == Br || betweenLength+Br == Ar) System.out.println(1);
            else{
                if (len == betweenLength) System.out.println(1);
                else if (len > betweenLength) System.out.println(2);
                else System.out.println(0);
            }
        }
	}
}





