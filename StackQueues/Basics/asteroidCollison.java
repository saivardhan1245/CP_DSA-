//https://leetcode.com/problems/asteroid-collision/
class asteroidCollison{
     public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            int ele = asteroids[i];
            if(ele>0){
                st.push(ele);
            }else{
                // ele -ve && more than peek
                boolean flag = true;
                while(!st.isEmpty() && st.peek() > 0 ){
                    int neg = -ele;
                    if(st.peek() < neg ){
                        st.pop();
                    }else if( st.peek() == neg){
                        st.pop();
                        flag = false;
                        break;
                        
                    }else{
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    st.push(ele);
                }          

            }
              
        }
        int[] res = st.stream().mapToInt(i->i).toArray();
        return res;

    }
}