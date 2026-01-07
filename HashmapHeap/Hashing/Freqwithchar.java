package Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Freqwithchar {
    //Maximum frequency character

   // https://www.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1
   public char getMaxOccuringChar(String s) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0 ;
        char maxChar = 's';
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)==false){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
            
        }
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(map.get(ch)>maxFreq){
                maxFreq = map.get(ch);
                maxChar = ch;
            }
            else if(map.get(ch)==maxFreq && ch < maxChar){
                maxChar = ch;
            }
        }
        return maxChar;
    }
}
