import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int value, i;
        int length = sc.nextInt();
        int[] arr = new int[length];
        
        // 배열에 값 저장
        for(i=0;i<length;i++){
            arr[i] = sc.nextInt();
        }
        
        // 값 개수 찾기
        value = sc.nextInt();
        for(i=0;i<length;i++) 
            if(arr[i] == value) 
                cnt += 1;
        
        System.out.print(cnt);
    }
}