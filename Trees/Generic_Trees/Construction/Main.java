
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

    public static int getSize(TreeNode root) {

        int cnt = 0;
        for (TreeNode node : root.children) {
            cnt += getSize(node);
        }
        return 1 + cnt;
    }

    public static int getMax(TreeNode root) {
        int max = root.data;
        for (TreeNode node : root.children) {
            int childMax = getMax(node);
            max = Math.max(max, childMax);
        }
        return max;
    }

    public static int getHeight(TreeNode root) {
        int h = 0;
        for (TreeNode node : root.children) {
            int ch = 1 + getHeight(node);
            h = Math.max(h, ch);
        }
        return h;
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, 110, -1, 120, -1, -1, 100, -1, -1, -1};
        TreeNode root = constructTree(data);
        // display(root);
        // 10->20,30,40,
        // 20->50,60,
        // 50->
        // 60->
        // 30->70,
        // 70->
        // 40->80,90,100,
        // 80->
        // 90->110,120,
        // 110->
        // 120->
        // 100->
        //int len = getSize(root);
        //System.out.println(len);
        //System.out.println("max :" + getMax(root));
        // System.out.println("get depth :" + getHeight(root));
    }
}
