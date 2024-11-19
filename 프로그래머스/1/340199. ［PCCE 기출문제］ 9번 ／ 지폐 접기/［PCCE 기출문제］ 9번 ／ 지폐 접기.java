import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        swap(wallet);
        swap(bill);
        
        while(true) {
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;

            bill[0] /= 2;
            swap(bill);
            answer++;
        }
        
        return answer;
    }
    
    static void swap(int[] arr) {
        if (arr[1] > arr[0]) {
            int temp = arr[1];
            arr[1] = arr[0];
            arr[0] = temp;
        }
    }
}