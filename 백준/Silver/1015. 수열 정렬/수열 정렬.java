import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int min=0;
        int[] A = new int[size];
        int[] B = new int[size];
        String[] temp = (br.readLine()).split(" ");
        
        for(int i=0;i<size;i++) {
            A[i] = Integer.parseInt(temp[i]);
        }
        
        
        for (int i = 0; i < size; i++) {
            min=0;
            for (int j = 1; j < size; j++) {
                if (A[min] > A[j]) {
                    min=j;
                }
            }
            A[min] = 1001;
            B[min] = i;
        }

        for (int i : B) {
            System.out.print(i+ " ");
        }
	}
}