import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int y = (a*f - d*c) / (a*e - b*d);;
        int x;
        
        if(a != 0){
            x = (-1*b*y + c) / a;
        } else {
            x = (-1*e*y + f) / d;
        }
        System.out.print(x + " " + y);
	}
}