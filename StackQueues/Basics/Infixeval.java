import java.util.*;
public class Infixeval{
    public static  int precedence(char op){
        if(op=='^'){
            return 3;
        }
        if(op=='/' || op=='*'){
            return 2 ;
        }else if(op=='+' || op =='-'){
            return 1;
        }else{
            return 0;
        }
    }
    public  static    int eval(int a ,int b , char op){
        if(op=='+'){
            return a+b;
        } else if(op=='-'){
            return a-b;
        } else if(op=='*'){
            return a*b;
        } else if(op=='^'){
            return (int)Math.pow(a, b);
        }
        else 
        {
            return a/b;
        }
        
    }
    public static int res(String e){
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i = 0 ; i < e.length() ; i++){
            char ch = e.charAt(i);
            if(ch >='0' && ch<='9'){
                operand.push(ch-'0');
            }
            else if(ch=='('){
                operator.push(ch);
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch =='/' ||ch=='^'){
                while(operator.size()>0 && precedence(operator.peek())>precedence(ch) || (precedence(operator.peek())== precedence(ch)) && ch=='^'){
                    char op = operator.pop(); //m
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int res = eval(v1, v2, op);
                    operand.push(res);
                }
                operator.push(ch);
            }
            else if(ch==')'){
                while(operator.peek()!='('){ //m
                    char op = operator.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int res = eval(v1, v2, op);
                    operand.push(res);
                }
                operator.pop();
            }
        }
        while(operator.size()>0){
                    char op = operator.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int res = eval(v1, v2, op);
                    operand.push(res);
        }
        return operand.peek();
    }
    public static void main(String[] args) {
        String exp = "(9+5-8*6)";
        System.out.println(res(exp));
    }
}