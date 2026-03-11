//https://leetcode.com/problems/remove-outermost-parentheses/description/
class removeOuterPar{
    class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int cnt = 0 ;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                // if cnt =>0 outer most par (
                if(cnt!=0){
                    str.append(ch);
                }
                cnt++;
            }else{
                //  if cnt => 1 outer most par )
                if(cnt!=1){
                    str.append(ch);
                }
                cnt--;
            }
        }
        return str.toString();
    }
}
}