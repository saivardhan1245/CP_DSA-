import java.util.Stack;
public class InfixtoPrefixPostfix {
    public static int preceedence(char op){
        if(op=='^'){
            return 3;
        }
        if(op=='+' || op=='-'){
            return 1;
        } else if(op=='*' || op=='/'){
            return 2;
        } else{
            return 0 ;
        }
    }
    
    public static void convert(String s){
        Stack<Character> operator = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                prefix.push(ch+"");
                postfix.push(ch+"");
            }else if(ch=='('){
                operator.push(ch);
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                while(operator.size()>0 && preceedence(operator.peek())>preceedence(ch)  && ( preceedence(operator.peek())==preceedence(ch) && ch!='^')){
                    char c = operator.pop();
                    String b = prefix.pop();
                    String a = prefix.pop();
                    String pre = c+a+b;
                    prefix.push(pre);
                    String v2 = postfix.pop();
                    String v1 = postfix.pop();
                    String post = a+b+c;
                    postfix.push(post);
                }
                operator.push(ch);
            } else if(ch==')'){
                while(operator.peek()!='('){
                   char c = operator.pop();
                    String b = prefix.pop();
                    String a = prefix.pop();
                    String pre = c+a+b;
                    prefix.push(pre);
                    String v2 = postfix.pop();
                    String v1 = postfix.pop();
                    String post = a+b+c;
                    postfix.push(post); 
                }
                operator.pop();
            }
        }
        while(operator.size()>0){
                    char c = operator.pop();
                    String b = prefix.pop();
                    String a = prefix.pop();
                    String pre = c+a+b;
                    prefix.push(pre);
                    String v2 = postfix.pop();
                    String v1 = postfix.pop();
                    String post = a+b+c;
                    postfix.push(post);
        }
        System.out.println("prefix  "+prefix.peek());
        System.out.println("postfix "+postfix.peek());
    }
    public static void main(String[] args) {
        String e = "2^3^2";
        convert(e);
    }
}
