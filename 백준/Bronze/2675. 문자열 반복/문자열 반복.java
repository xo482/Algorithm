import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String total = "";
       
        for(int i=0;i<cnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String token = st.nextToken();
            
            for(int j = 0; j < token.length(); j++){
                String str = String.valueOf(token.charAt(j)).repeat(repeat);
                total += str;        
            }
            total += "\n";
                   
        }
        System.out.print(total);
    }
}
