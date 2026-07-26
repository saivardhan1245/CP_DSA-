
import java.util.*;

class TreeNode {

    int data;
    ArrayList<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}

public class Main {

    public static TreeNode constructTree(int[] data) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = null;
        for (int ele : data) {
            if (ele == -1) {
                st.pop();
            } else {
                TreeNode nn = new TreeNode(ele);
                if (st.size() == 0) {
                    root = nn;
                } else {
                    st.peek().children.add(nn);
                }
                st.push(nn);
            }
        }
        return root;
    }

    public static void display(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        for (TreeNode node : root.children) {
            System.out.print(node.data + ",");
        }
        System.out.println();
        for (TreeNode node : root.children) {
            display(node);
        }

    }

    public static TreeNode mirrorTree(TreeNode root) {
        int len = root.children.size();
        int l = 0, r = len - 1;
        while (l <= r) {
            TreeNode leftMirror = mirrorTree(root.children.get(l));
            TreeNode rightMirror = (l < r) ? mirrorTree(root.children.get(r)) : root.children.get(r);
            root.children.set(l, rightMirror);
            root.children.set(r, leftMirror);
            l += 1;
            r -= 1;
        }
        return root;
    }

    public static TreeNode removeLeafNode(TreeNode root) {
        if (root == null || root.children.isEmpty()) {
            return null;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode child = root.children.get(i);
            TreeNode curr = removeLeafNode(child);
            if (curr == null) {
                root.children.remove(i);
                i--;
            }
        }
        // for (int i = root.children.size() - 1; i >= 0; i--) {
        //     TreeNode child = root.children.get(i);

        //     if (removeLeafNode(child) == null) {
        //         root.children.remove(i);
        //     }
        // }
        return root;
    }

    public static void removeLeafNode_Preorder(TreeNode root) {

        for (int i = root.children.size() - 1; i >= 0; i--) {
            TreeNode child = root.children.get(i);
            if (child.children.isEmpty()) {
                root.children.remove(i);
            }
        }
        for (TreeNode child : root.children) {
            removeLeafNode_Preorder(child);
        }
    }

    public static TreeNode findTail(TreeNode root) {
        TreeNode temp = root;
        while (temp.children.size() > 0) {
            temp = temp.children.get(0);
        }
        return temp;
    }

    public static TreeNode linearizeGT(TreeNode root) {

        for (TreeNode child : root.children) {
            linearizeGT(child);
        }
        while (root.children.size() > 1) {
            int len = root.children.size();

            TreeNode lastChild = root.children.get(len - 1);
            TreeNode secLastChild = root.children.get(len - 2);
            TreeNode tail = findTail(secLastChild);
            root.children.remove(len - 1);
            tail.children.add(lastChild);
        }
        return root;

    }

    public static TreeNode linearizedGT_better(TreeNode root) {

        if (root.children.isEmpty()) {
            return root;
        }
        TreeNode lastChildTail = linearizedGT_better(root.children.get(root.children.size() - 1));
        while (root.children.size() > 1) {
            int len = root.children.size();
            TreeNode lastChild = root.children.get(len - 1);
            TreeNode seclastChild = root.children.get(len - 2);
            TreeNode seclastChildTail = linearizedGT_better(seclastChild);
            root.children.remove(len - 1);
            seclastChildTail.children.add(lastChild);
        }
        return lastChildTail;
    }

    public static boolean find(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        for (TreeNode child : root.children) {
            boolean flag = find(child, target);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<TreeNode> nodeToPath(TreeNode root, int target) {
        if (root.data == target) {
            ArrayList<TreeNode> baseArr = new ArrayList<>();
            baseArr.add(root);
            return baseArr;
        }

        for (TreeNode child : root.children) {
            ArrayList<TreeNode> res = nodeToPath(child, target);
            if (!res.isEmpty()) {
                res.add(root);
                return res;
            }
        }

        return new ArrayList<>();
    }

    public static TreeNode findLCA(TreeNode root, int tar1, int tar2) {
        ArrayList<TreeNode> ca1 = nodeToPath(root, tar1);
        ArrayList<TreeNode> ca2 = nodeToPath(root, tar2);

        TreeNode lca = null;
        int i = ca1.size() - 1, j = ca2.size() - 1;
        while (i >= 0 && j >= 0 && ca1.get(i).data == ca2.get(j).data) {
            lca = ca1.get(i);
            i--;
            j--;
        }
        return lca;//ca1.get(i+1);
    }

    public static boolean isMirror(TreeNode n1,TreeNode n2){
        if(n1.data!=n2.data || n1.children.size()!=n2.children.size()){
            return false;
        }
        int i = 0 , j = n1.children.size()-1;
        while(i <= j){
            boolean flag = isMirror(n1.children.get(i),n2.children.get(j));
            if(!flag){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isSymmetric(TreeNode root){
        return isMirror(root,root);   
    }
    public static void main(String[] args) {
      //  int[] data = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, 110, -1, 120, -1, -1, 100, -1, -1, -1};
        // int[] data = {10, 20, 30, -1, -1, -1};
        //TreeNode root = constructTree(data);
        // display(root);
        // TreeNode mirror = mirrorTree(root);
        // TreeNode removeLeaf = removeLeafNode(root);
        // TreeNode linearRoot = linearizeGT(root);
        // linearizedGT_better(root);
        // display(root);
        // System.out.println("check 80 ? " + find(root, 80));
        // System.out.println("check 105 ? " + find(root, 105));

        // ArrayList<TreeNode> res = nodeToPath(root, 80);
        // Collections.reverse(res);
        // for (TreeNode node : res) {
        //     System.out.print(node.data + " ");
        // }
        // System.out.println();
       // TreeNode c_lca = findLCA(root, 110, 120);
        //System.out.println(c_lca.data);
        // isSymmetric(root,root);
    }
}
