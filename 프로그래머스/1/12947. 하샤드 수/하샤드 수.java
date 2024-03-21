class Solution {
    public boolean solution(int x) {
    
        int sum = String.valueOf(x).chars()
            .map(Character::getNumericValue)
            .sum();
        
        if(x % sum == 0)
            return true;
        return false;
    }
}