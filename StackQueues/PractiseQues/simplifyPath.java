//https://leetcode.com/problems/simplify-path/description/
class simplifyPath {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        String[] words = path.split("/");
        for(String str:words){
            if(str.equals(".") || str.equals("")){
                continue;
            }else if(str.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(str);
            }
        }
        if(st.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append("/"+st.removeLast());
        }

        return sb.toString();
    }
}