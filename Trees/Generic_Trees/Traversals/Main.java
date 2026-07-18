
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

    public static void traverse(TreeNode root) {
        System.out.println("pre-order :" + root.data);
        for (TreeNode child : root.children) {
            System.out.println("Traversing from " + root.data + "->" + child.data);
            traverse(child);
            System.out.println("Traversing from " + child.data + "->" + root.data);
        }
        System.out.println("Post order: " + root.data);
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, 110, -1, 120, -1, -1, 100, -1, -1, -1};
        TreeNode root = constructTree(data);
        traverse(root);
        /*
            pre-order :10
            Traversing from 10->20
            pre-order :20
            Traversing from 20->50
            pre-order :50
            Post order: 50
            Traversing from 50->20
            Traversing from 20->60
            pre-order :60
            Post order: 60
            Traversing from 60->20
            Post order: 20
            Traversing from 20->10
            Traversing from 10->30
            pre-order :30
            Traversing from 30->70
            pre-order :70
            Post order: 70
            Traversing from 70->30
            Post order: 30
            Traversing from 30->10
            Traversing from 10->40
            pre-order :40
            Traversing from 40->80
            pre-order :80
            Post order: 80
            Traversing from 80->40
            Traversing from 40->90
            pre-order :90
            Traversing from 90->110
            pre-order :110
            Post order: 110
            Traversing from 110->90
            Traversing from 90->120
            pre-order :120
            Post order: 120
            Traversing from 120->90
            Post order: 90
            Traversing from 90->40
            Traversing from 40->100
            pre-order :100
            Post order: 100
            Traversing from 100->40
            Post order: 40
            Traversing from 40->10
            Post order: 10
         */

    }
}
