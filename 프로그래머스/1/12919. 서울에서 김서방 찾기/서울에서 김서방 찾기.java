class Solution {
    public String solution(String[] seoul) {
        int i=-1;
        while(!(seoul[++i].equals("Kim"))) {}
        return "김서방은 " + i + "에 있다";
    }
}