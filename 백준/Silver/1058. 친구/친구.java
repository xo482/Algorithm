import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        String[][] matrix = new String[people][people];
        int max =0, cnt;

        // init
        for(int i=0; i<people; i++){
            String[] line = br.readLine().split("");
            for(int j=0;j<people;j++)
                matrix[i][j] = line[j];
        }

        // i: 나 , j: 친구 , k: 친구의 친구
        for(int i=0; i<people; i++){

            cnt = 0;
            boolean[] list = new boolean[people];


            for(int j=0;j<people;j++){

                if(matrix[i][j].equals("Y") && (i != j) && !list[j]){

                    cnt++;
                    list[j] = true;

                    for(int k=0; k<people; k++){

                        if(matrix[j][k].equals("Y") && matrix[i][k].equals("N") && (i != k) && !list[k]) {
                            list[k] = true;
                            cnt++;
                        }
                    }
                }
            }
            if (cnt > max) max = cnt;
        }

        System.out.print(max);
    }
}