public class removeAllOccsubstring {
    //https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
    class Solution {
    public String removeOccurrences(String s, String part) {
       // Deque<String> st = new ArrayDeque<>();
        int p = part.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
             sb.append(ch);
            while(sb.length()>=p ){
                String check = sb.substring(sb.length()-p);
                if(check.equals(part)){
                    sb.delete(sb.length()-p,sb.length());
                }else{
                    break;
                }
            }
         
          
        }
        // while(sb.length()>=p ){
        //         String check = sb.substring(sb.length()-p);
        //         if(check.equals(part)){
        //             sb.delete(sb.length()-p,sb.length());
        //         }else{
        //             break;
        //         }
        //     }
        return sb.toString();
    }
}
}
