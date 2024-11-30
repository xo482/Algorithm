class Solution {
    public long solution(int price, int money, int count) {
        
        if((long)price*(long)count*(long)(count+1)/(long)2 - (long)money < 0) return 0;
        return (long)price*(long)count*(long)(count+1)/(long)2 -(long) money;
    }
}