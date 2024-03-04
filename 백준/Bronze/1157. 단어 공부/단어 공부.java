import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> maxKeys = new HashSet<>();
        
        for(int i = 0; i< 26; i++){
            char x = (char)(65+i);
            String key = String.valueOf(x);
            map.put(key, 0);
        }
        
        for(int i=0;i<str.length();i++){
            String key = String.valueOf(str.charAt(i));
            int val = map.get(key);
            map.put(key, val+1);
        }
        
        int max=0;
        for (String key : map.keySet()) {
            int value = map.get(key);
            
            if(value > max){
                max = value;
                maxKeys.clear(); // 이전에 저장된 최댓값을 가지는 키들을 모두 제거
                maxKeys.add(key); // 새로운 최댓값의 키 추가
            } else if (value == max) {
                maxKeys.add(key); // 새로운 최댓값의 키 추가
            }
        }
        
        if(maxKeys.size() == 1){
            String firstKey = maxKeys.iterator().next();
            System.out.print(firstKey);
        }else if (maxKeys.size() > 1)
            System.out.print("?");
        
    }
}