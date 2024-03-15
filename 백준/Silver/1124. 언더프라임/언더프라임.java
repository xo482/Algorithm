import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // 인덱스에 해당하는 숫자가 -> false: 소수 , true: 합성수
        boolean[] prime = new boolean[100001];
        
        // 인덱스에 해당하는 숫자의 소수의 개수를 담을 리스트
        int[] count = new int[100001];
        
        // 0, 1은 소수가 될 수 없음
        prime[0] = prime[1] = true;
        
        for(int i = 2; i < 100001; i++){
            // 만약 true면 이미 합성수라는 뜻임
            if(prime[i]) continue;
            
            // 위의 조건문을 지나왔다면 일단 i는 소수임
            for(int j = i+i; j < 100001; j += i){
                // 해당하는 소수의 배수들은 전부 합성수이므로 true로 만들어줌
                // 이후에 그 수가 i의 값이 된다면 위의 조건문에 걸려서 지나감
                prime[j] = true;
                
                // 제곱 근의 개수만큼 리스트 값 증가시킴
                // j는 그 수만큼 i를 가지고 있음
                // ex) j=169, i=13일 때 j는 i를 인수로 2개 가짐
                int tmp = j;
                while(tmp % i == 0){
                    tmp /= i;
                    count[j]++;
                }
            }
        }
        
        // i의 소수의 개수를 가져오고, 그 수가 소수인지 확인
        int cnt = 0;
        for(int i = a; i <= b; i++){
            if(!prime[count[i]]) cnt++;
        }
        
        System.out.println(cnt);
    }
}