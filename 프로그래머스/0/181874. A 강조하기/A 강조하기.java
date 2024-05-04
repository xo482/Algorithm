class Solution {
    public String solution(String myString) {
        char[] list = myString.toLowerCase().toCharArray();
        
        for(int i = 0; i < myString.length(); i++) 
            if(list[i] == 'a') 
                list[i] = 'A';
        
        return new String(list);
    }
}