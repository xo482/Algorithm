import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] str = video_len.split(":");
        int videoTime = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        str = pos.split(":");
        int posTime = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        str = op_start.split(":");
        int startTime = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        str = op_end.split(":");
        int endTime = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        
        if(startTime <= posTime && posTime <= endTime) posTime = endTime;
        
        for(String command : commands) {
            if(command.equals("next")) posTime += 10;
            if(command.equals("prev")) posTime -= 10;
            
            if(posTime < 0) posTime = 0;
            if(posTime > videoTime) posTime = videoTime;
            if(startTime <= posTime && posTime <= endTime) posTime = endTime;
        }
        
        String mm;
        if(posTime/60 < 10) mm = "0" + posTime/60;
        else mm = String.valueOf(posTime/60);
        
        String ss;
        if(posTime%60 < 10) ss = "0" + posTime%60;
        else ss = String.valueOf(posTime%60);
        
        return mm + ":" + ss;
    }
}