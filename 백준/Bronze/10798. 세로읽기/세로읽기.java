import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] matrix = new String[5][15];
        String str = "";
        
        for(int i=0; i<5; i++){
            for(int j=0; j<15; j++){
                matrix[i][j] = "";
            }
        }
        
        for(int i=0; i<5; i++){
            String[] line = br.readLine().split("");
            int len = line.length;
            for(int j=0; j<len; j++){
                matrix[i][j] = line[j];
            }
        }
        
        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                str += matrix[j][i];
            }
        }
        
        System.out.print(str);
	}
}