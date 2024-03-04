import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = N;
        for(int i=2; i<=len; i++) {
            if(N % i == 0){
                N = N / i;
                System.out.println(i--);
            }
        }
	}
}