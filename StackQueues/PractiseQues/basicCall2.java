//https://leetcode.com/problems/basic-calculator-ii/description/

import java.util.ArrayDeque;
import java.util.Deque;

class basicCall2 {
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        //     s = s.replace(" ","");
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    st.push(num);
                } else if (op == '-') {
                    st.push(-num);
                } else if (op == '*') {
                    st.push(st.pop() * num);
                } else {
                    st.push(st.pop() / num);
                }
                op = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}






























