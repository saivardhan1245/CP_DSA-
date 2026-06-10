package RecursionBacktracking.ROWD;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class getKeyPadCharr {
    
class Solution {
    static String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
    public List<String> letterCombinations(String str) {
    // base case;
        if(str.length()==0){
            List<String> bArr = new ArrayList<>();
            bArr.add("");
            return bArr;
        }
        String smallerstr = str.substring(1);
        List<String> smallerAns = letterCombinations(smallerstr);

        List<String> myAns = new ArrayList<>();
        int fd = str.charAt(0)-'0';
        String fl = letters[fd];
        for(char ch:fl.toCharArray()){
            for(String sa:smallerAns){
                myAns.add(ch+sa);
            }
        }
        return myAns;
    }
}

}
