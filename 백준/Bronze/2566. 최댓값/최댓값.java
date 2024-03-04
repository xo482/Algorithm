import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[9][9];
        int row=0, col=0, max=0;
        
        
        for(int i=0; i<9;i++){
            String[] rows = br.readLine().split(" ");
            for(int j=0; j<9;j++){
                matrix[i][j] = Integer.parseInt(rows[j]);
                if(matrix[i][j] > matrix[row][col]){
                    row = i;
                    col = j;
                }
            }
        }
        
        System.out.println(matrix[row][col]);
        System.out.print((row+1) + " " + (col+1));
	}
}