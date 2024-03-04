import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int loop = Integer.parseInt(st.nextToken());
        int[] list = new int[len];
        int temp;     
        for(int i=0;i<len;i++){
            list[i] = i+1;
        }     
        for(int i=0;i<loop;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;    
            while(true){
                if (start >= end) break;
                temp = list[start];
                list[start] = list[end];
                list[end] = temp;   
                start++;
                end--;
            }
        }
        for(int i=0;i<len;i++){
            System.out.print(list[i] + " ");
        }
    }
}