import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minPriceOfSet = 1001; // 세트 최소 가격
        int minPriceOfOne = 1001; // 낱개 최소 가격
        int sum=0;
        
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int PriceOfSet = Integer.parseInt(st.nextToken());
            int PriceOfOne = Integer.parseInt(st.nextToken());
            if(PriceOfSet < minPriceOfSet) minPriceOfSet = PriceOfSet;
            if(PriceOfOne < minPriceOfOne) minPriceOfOne = PriceOfOne;
        }
        
        if(minPriceOfSet < 6 * minPriceOfOne) sum = sum + ((N / 6) * minPriceOfSet);
        else sum = sum + ((N / 6) * 6 * minPriceOfOne);
        
        if (((N%6)*minPriceOfOne) > minPriceOfSet) sum += minPriceOfSet;
        else sum = sum + ((N%6)*minPriceOfOne);
        
        System.out.println(sum);
	}
}