import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[100][100];
        int len = Integer.parseInt(br.readLine());
        int cnt =0;
        
        for(int i=0; i<len; i++) {
            String[] point = br.readLine().split(" ");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            
            for(int j=x;j<x+10;j++){
                for(int k=y;k<y+10;k++){
                    matrix[j][k] = 1;
                }
            }
        }
        
        for(int j=0;j<100;j++){
            for(int k=0;k<100;k++){
                cnt += matrix[j][k];
            }
        }
        System.out.print(cnt);
	}
}