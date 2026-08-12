class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        left = null;
        right=null;
    }
}
class Main{
    public static TreeNode buildTree(int[] arr,int si,int ei){
        if(si>ei){
            return null;
        }
        int m = si + (ei-si)/2;
        TreeNode root = new TreeNode(arr[m]);
        root.left = buildTree(arr,si,m-1);
        root.right = buildTree(arr,m+1,ei);
        return root;

    }
    // MIN IN BST
    //https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
    public int minValue(TreeNode root) {
        // code here
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null){
            return root.data;
        }
        return minValue(root.left);
    }
    public int minValue_Iterative(TreeNode root) {
        // code here
        
        if(root == null){
            return Integer.MAX_VALUE;
        }
        while(root.left!=null){
            root = root.left;
        }
        return root.data;
    }
    //MAX IN BST
    public int maxValue(TreeNode root) {
        // code here
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.right==null){
            return root.data;
        }
        return maxValue(root.right);
    }
    // SEARCH IN BST
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.data == val){
            return root;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        
        if(root.data > val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
    }
    public TreeNode searchBST_Iterative(TreeNode root, int val) {
       
        while(root!=null){
            if(root.data > val){
                root = root.left;
            }else if(root.data < val){
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,5,8,11,12,13,15,18};
        TreeNode root = buildTree(arr,0,arr.length-1);
    }
}