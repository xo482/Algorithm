class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        
        for(double x : numbers) {
            sum += x;
        }
        
        return sum / numbers.length;
    }
}