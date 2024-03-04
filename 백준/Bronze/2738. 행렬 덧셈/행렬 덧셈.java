import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[rows][cols];
        
        for(int i=0; i<rows; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<cols; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<rows; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<cols; j++){
                matrix[i][j] += Integer.parseInt(st.nextToken());
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
	}
}