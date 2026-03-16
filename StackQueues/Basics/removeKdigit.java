//https://leetcode.com/problems/remove-k-digits/

import java.util.Stack;

class removeKdigit {
    public String removeKdigits(String num, int k) {
          
        int n = num.length();
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n  ; i++){
            int digit = num.charAt(i)-'0';
            while(!st.isEmpty() && st.peek() > digit ){
                
                if(k>0){
                    st.pop();
                    k--;
                }else{
                    break;
                }
                   
            }
            st.push(digit);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        
        int j = str.length()-1;
        while(j>=0 && str.charAt(j) == '0' ){
            str.deleteCharAt(j);
            j--;
        }
        String res = str.reverse().toString();
       
        
       return res.length()==0 ?"0":res;
    }
}
