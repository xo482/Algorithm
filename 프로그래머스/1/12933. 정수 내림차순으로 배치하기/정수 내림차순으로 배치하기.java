import java.util.Arrays;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(n);
        int len = str.length();
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr);
    
        for(int i = 0; i < len; i++) {
           sb.append(arr[len-i-1]);
        }

        return Long.parseLong(sb.toString());
    }
}