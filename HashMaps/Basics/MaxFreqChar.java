package HashMaps.Basics;

import java.util.HashMap;

public class MaxFreqChar {
    //https://www.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1
    public char getMaxOccuringChar(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        /*
        t - 2 f - 2
        ans = t => f (if ans>ch)
        */
        int maxFreq = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            } else{
                int old = map.get(ch);
                map.put(ch,old+1);
            }
            maxFreq = Math.max(maxFreq,map.get(ch));
        }
        char ans = '\0';
        for(int i = 0  ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(map.get(ch)==maxFreq){
                if(ans=='\0'){
                    ans = ch;
                }
                else if(ans>ch){
                    ans = ch;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
