class Solution {
    public static String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args){
        System.out.print(solution("jaron"));
    }
}