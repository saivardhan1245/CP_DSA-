package Trees.GenericTrees.Construction;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {

    int data;

    ArrayList<TreeNode> children;

    public TreeNode(int data){

    this.data = data;

    children = new ArrayList<>();

    }
    
}

public class Main {
    public static TreeNode construct(int[] dataArray){
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = null;
        for(int ele:dataArray){
            if(ele == -1 ){
                st.pop();
            }else{
                 TreeNode newnode = new TreeNode(ele);
                if(st.size()==0){
                    root = newnode;
                } else{
                   
                    st.peek().children.add(newnode);
                }
                st.push(newnode);
            }
            
        }
        return root;
    }
    public static void display(TreeNode root){
        if(root==null){
            System.out.println("tree is empty");
        }else{
            System.out.print(root.data +"->");
            
            
            
              ArrayList<TreeNode> chd = root.children;
              for(TreeNode ele:chd){
                System.out.print(ele.data+",");
              }
              System.out.println();
            //   if(root.children.size()==0){
            //     return;
            //   }
            //   for(int i = 0 ; i < chd.size();i++){
            //     display(root.children.get(i));
            //   }
            for(TreeNode child:chd){
                display(child);
            }
              
        }
    }
    public static int size(TreeNode root){
        int cnt = 0 ;
        for(TreeNode chld : root.children){
            cnt += size(chld);
        }
        return cnt+1;
    }
    public static int getMaximum(TreeNode root){
        int max = root.data;
        for(TreeNode chld :root.children){
            max = Math.max(max,getMaximum(chld));
        }
        return max;
}
    public static void main(String[] args) {
        int[] dataArray = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,80,-1,90,110,-1,120,-1,-1,100,-1,-1,-1};
        TreeNode root = construct(dataArray);
        display(root);
        System.out.println(size(root));
        System.out.println(getMaximum(root));
    }
}
