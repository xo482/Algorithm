import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int len = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] list = new int[len];
        
        for(int i=0;i<len;i++){
            list[i] = i+1;
        }
        
        for(int i=0;i<count;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()) - 1;
            int num2 = Integer.parseInt(st.nextToken()) - 1;
            int temp;
            
            temp = list[num1];
            list[num1] = list[num2];
            list[num2] = temp;
            
        }
            
        for(int i=0;i<len;i++){
            System.out.print(list[i] + " ");
        }
   
    }
}
