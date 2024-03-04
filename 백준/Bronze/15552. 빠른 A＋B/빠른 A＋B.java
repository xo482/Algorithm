import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine()); //Int
        
        for(int i=0;i<T;i++){
            String s = bf.readLine(); //String
            String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
            int sum = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
            bw.write(sum+"\n");   //버퍼에 있는 값 전부 출력
        }
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}