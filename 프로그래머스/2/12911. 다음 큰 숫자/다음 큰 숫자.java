class Solution {
    public int solution(int n) { 
        int cnt = count(n);
        while(true){
            if(cnt == count(++n)){
                return n;
            }
        }
    }
    public static int count(int input){
        StringBuilder sb = new StringBuilder ();
        int cnt = 0;
        while(input >= 2){
            if(input % 2 == 1) cnt++;
            input /= 2;
        } 
        if(input == 1) cnt++;
        return cnt;
    }
}