//https://leetcode.com/problems/maximum-score-from-removing-substrings
class Solution {
    public int maximumGain(String s, int x, int y) {
        int first = Math.max(x, y);
        int second = Math.min(x, y);
        String fr = (x < y) ? "ba" : "ab";
        String sr = (x < y) ? "ab" : "ba";
        int pts = 0 ;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {

            if (sb.length() >= 1 && sb.charAt(sb.length() - 1) == fr.charAt(0) && ch == fr.charAt(1)) {
                sb.deleteCharAt(sb.length() - 1);
                pts+=first;
            }else{
                sb.append(ch);
            }

        }
        StringBuilder sb2 = new StringBuilder();
         for (char ch : sb.toString().toCharArray()) {

            if (sb2.length() >= 1 && sb2.charAt(sb2.length() - 1) == sr.charAt(0) && ch == sr.charAt(1)) {
                sb2.deleteCharAt(sb2.length() - 1);
                pts+=second;
            }else{
                sb2.append(ch);
            }
        }
        return pts;
    }
}