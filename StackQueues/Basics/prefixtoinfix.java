import java.util.Stack;
 class PrefixProcess {

    public static int eval(int a,int b,char op){
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        if(op=='*') return a*b;
        return a/b;
    }

    public static void solve(String s){

        Stack<String> infix = new Stack<>();
        Stack<Integer> value = new Stack<>();

        for(int i=s.length()-1;i>=0;i--){

            char ch = s.charAt(i);

            if(ch>='0' && ch<='9'){
                infix.push(ch+"");
                value.push(ch-'0');
            }
            else{

                String a = infix.pop();
                String b = infix.pop();
                infix.push("("+a+ch+b+")");

                int x = value.pop();
                int y = value.pop();
                value.push(eval(x,y,ch));
            }
        }

        System.out.println("Infix = "+infix.peek());
        System.out.println("Value = "+value.peek());
    }

    public static void main(String[] args){
        String s = "-+2*345";
        solve(s);
    }
}


class PostToInfix {

    public static void convert(String s){

        Stack<String> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch>='0' && ch<='9'){
                st.push(ch+"");
            }
            else{

                String a = st.pop();
                String b = st.pop();

                String infix = "(" + b + ch + a + ")";
                st.push(infix);
            }
        }

        System.out.println(st.peek());
    }

    public static void main(String[] args){
        String s = "234*+5-";
        convert(s);
    }
}

class PreToPost {

    public static void convert(String s){

        Stack<String> st = new Stack<>();

        for(int i=s.length()-1;i>=0;i--){

            char ch = s.charAt(i);

            if(ch>='0' && ch<='9'){
                st.push(ch+"");
            }
            else{

                String a = st.pop();
                String b = st.pop();

                String post = a + b + ch;
                st.push(post);
            }
        }

        System.out.println(st.peek());
    }

    public static void main(String[] args){
        String s = "-+2*345";
        convert(s);
    }
}