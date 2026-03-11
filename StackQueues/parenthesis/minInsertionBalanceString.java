//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
class minInsertionBalanceString {
    public int minInsertions(String s) {
        int extra_open = 0 , extra_close = 0 , close_req = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                extra_open++;
            }else{
                if( (i+1 < s.length()) && s.charAt(i+1)==')'){
                    i++;  // conseq ))
                }
                else{
                    close_req++; // single ) 
                }
                if(extra_open==0){
                    extra_close++;
                }else{
                    extra_open--;
                }
            }
        }
        return 2*extra_open + close_req + extra_close;
    }
}