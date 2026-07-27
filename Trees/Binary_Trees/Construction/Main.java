import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
    }
}
class Pair{
    TreeNode node;
    int child;
    public Pair(TreeNode node ,int child){
        this.node = node;
        this.child = child;
    }
}
public class Main{

    public static TreeNode buildTree(Integer[] arr){

        Stack<Pair> st = new Stack<>();
        TreeNode root = null;
        for(Integer ele:arr){
            if(ele == null){
                if(st.isEmpty())
                    break;
                else{
                    if(st.peek().child == 0){
                        st.peek().child++;
                    }else{
                        st.pop();
                    }
                }
            }
            else{
            TreeNode node = new TreeNode(ele);
            if(st.isEmpty()){
                root = node;  
            }else{
                if(st.peek().child == 0){
                    st.peek().node.left = node;
                    st.peek().child++;
                   
                }else if(st.peek().child == 1){
                    st.peek().node.right = node;
                    st.peek().child++;
                    st.pop();
                } 
                
            }
             st.push(new Pair(node,0));
            }
        }
        return root;
    }
    public static void display(TreeNode root){
        if(root == null){
            return;
        }
        String nodeStr = (root.left == null? ".":root.left.data) +" <-- "+root.data+" --> "+(root.right==null?".":root.right.data);
        System.out.println( nodeStr );
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args){
        Integer[] arr = {10,20,40,null,60,null,null,50,70,null,null,null,30,80,null,90,null,null,100,null,null,null};
        TreeNode root = buildTree(arr);
        display(root);
    }
}