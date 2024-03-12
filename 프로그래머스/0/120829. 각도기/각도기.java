class Solution {
    public int solution(int angle) {
        if (angle / 90 == 0) return 1;
        else if (angle == 90) return 2;
        else if (angle / 90 == 1) return 3;
        else return 4;
    }
}