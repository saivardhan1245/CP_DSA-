
class  Minimum_Add_to_Make_Parentheses_Valid{
    public int minAddToMakeValid(String s) {
     
        int open = 0 , openReq = 0 ;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                } else{
                    openReq++;
                }
            }
        }
        return open + openReq;
    }
}
