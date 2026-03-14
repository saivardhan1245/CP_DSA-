// leetcode 678
//https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
import java.util.Stack;
    public boolean checkValidString(String s) {
        int max = 0 , min = 0 ;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                max++;
                min++;
            }else if(ch==')'){
                max--;
                min--;
            }else{
                max++;
                min--;
            }
            if(max < 0 ){
                return false;
            }
            if(min < 0 ){
                min = 0 ;
            }
        }
        return min == 0 ; 
    }

    public boolean checkValidString2(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                open.push(i);
            }
            else if(ch == '*'){
                star.push(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!open.isEmpty() && !star.isEmpty()){
            if(open.peek() < star.peek()){
                open.pop();
                star.pop();
            }
            else{
                return false;
            }
        }

        return open.isEmpty();
    }