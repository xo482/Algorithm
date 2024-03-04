import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        double[] arr = new double[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double totalScore = 0, max = 0;
        
        // 배열 초기화 & 최댓값 구하기
        for(int i=0;i<length;i++){
            double val = Double.parseDouble(st.nextToken());
            arr[i] = val;
            
            if(val > max) max = val;
        }
        
        // 점수 변환 & 점수 합 구하기
        for(int i=0;i<length;i++){
            arr[i] = arr[i] / max * 100;
            totalScore += arr[i];
        }
        
        // 평균 출력
        System.out.print(totalScore / length);
    }
}