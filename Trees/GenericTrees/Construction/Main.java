package Trees.GenericTrees.Construction;

import java.util.ArrayList;
import java.util.LinkedList;

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
        int max = root.data;//infintiy for -ve values consider 
        for(TreeNode child :root.children){
            max = Math.max(max,getMaximum(child));
        }
        return max;
}
   public static int getHeight(TreeNode root){
    if(root==null){return -1;}
        int height = -1 ;
        for(TreeNode child : root.children){
            height = Math.max(getHeight(child),height);
        }
        return height+1;
   }
   public static void levelOrderTraversal(TreeNode root){
    LinkedList<TreeNode> que = new LinkedList<>();
    que.addLast(root);
    while(!que.isEmpty()){
        TreeNode currNode = que.removeFirst();
        System.out.print(currNode.data+",");
        for(TreeNode child:currNode.children){
            que.add(child);
        }
    }
}
    public static void levelOrderwise(TreeNode root){
        LinkedList<TreeNode> mainQ = new LinkedList<>();
        mainQ.addLast(root);
        LinkedList<TreeNode> childQ = new LinkedList<>();
        int level = 1;
        while(mainQ.size()>0){
            
            TreeNode frontNode = mainQ.removeFirst();
            System.out.print(frontNode.data+",");
            
            for(TreeNode child:frontNode.children){
                childQ.add(child);
            }
            if(mainQ.size()==0){
                System.out.println();
                level++;
                mainQ = childQ;
                childQ = new LinkedList<>();
            }
            

        }
        
    }
    public static void levelOrder3(TreeNode root){
        LinkedList<TreeNode> mainQ = new LinkedList<>();
        mainQ.addLast(root);
        mainQ.addLast(null);
        int level = 1;
        while(!mainQ.isEmpty()){
            TreeNode parent = mainQ.removeFirst();
            if(parent!=null){
                System.out.print(parent.data+",");
                for(TreeNode child:parent.children){
                mainQ.addLast(child);
                }
            }
            
            
            else{
                level++;
                if(!mainQ.isEmpty()){
                    mainQ.addLast(null);
                }
                
                System.out.println();
            }
        }
    }
   
    public static void main(String[] args) {
        //int[] dataArray = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,80,-1,90,110,-1,120,-1,-1,100,-1,-1,-1};
        int[] dataArray = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,80,-1,90,110,-1,120,-1,-1,100,-1,-1,-1};
        TreeNode root = construct(dataArray);
        // display(root);
        // System.out.println(size(root));
       // System.out.println(getMaximum(root));
        //levelOrderTraversal(root);
       // levelOrderwise(root);
        levelOrder3(root);
    }
}
