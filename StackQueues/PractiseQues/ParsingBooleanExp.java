//https://leetcode.com/problems/parsing-a-boolean-expression/
class Solution {
    public boolean parseBoolExpr(String exp) {
        Deque<Character> st = new ArrayDeque<>();
        for(char ch:exp.toCharArray()){
            if(ch==','){
                continue;
            }
            else if(ch!=')'){
                st.push(ch);
            }else{
                int t = 0 , f = 0 ;
                while(!st.isEmpty() && st.peek()!='('){
                    if(st.pop()=='t'){
                        t++;
                    }else{
                        f++;
                    }
                }
                st.pop(); // pop ( 
                char optr = st.pop();
                if(optr=='|'){
                    char res = (t>0)?'t':'f';
                    st.push(res);
                }else if(optr=='&'){
                    char res = (f>0)?'f':'t';
                    st.push(res);
                }else{
                    char res = (t==1)?'f':'t';
                    st.push(res);
                }
            }
        }
        return st.peek()=='t'?true:false;
    }
}