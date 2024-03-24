class Solution {
    public int solution(long num) {
        int cnt = 0;
        
        while(num != 1 && cnt++ < 500)
            if (num % 2 == 0) num /= 2;
            else num = num * 3 + 1;
        
        if (cnt == 501) return -1;
        return cnt;
    }
}