class Solution {
    public int solution(int a, int b) {
        String s1 = a + "" + b;
        String s2 = b + "" + a;
        
        if(Integer.parseInt(s1) > Integer.parseInt(s2)) return Integer.parseInt(s1);
        return Integer.parseInt(s2);
    }
}