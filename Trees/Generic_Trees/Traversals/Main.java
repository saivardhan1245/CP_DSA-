
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
//=======================================================================================

    public static void traverse(TreeNode root) {
        System.out.println("pre-order :" + root.data);
        for (TreeNode child : root.children) {
            System.out.println("Traversing from " + root.data + "->" + child.data);
            traverse(child);
            System.out.println("Traversing from " + child.data + "->" + root.data);
        }
        System.out.println("Post order: " + root.data);
    }
//=====================================================================================

    public static void levelOrderTraversal_Recursive(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        System.out.print(root.data + " ");
        for (TreeNode child : root.children) {
            que.add(child);
            System.out.print(child.data + " ");
        }
        que.remove();
        while (!que.isEmpty()) {
            levelOrderTraversal_Recursive(que.remove());
        }
    }
//==========================================================================================

    public static void levelOrderTraversal_Iterative(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode curr = que.remove();
            System.out.print(curr.data + "->");
            for (TreeNode child : curr.children) {
                que.add(child);
            }

        }
    }
//==================================================================================================

    public static void levelOrderTraversal_LineWise1(TreeNode root) {
        Queue<TreeNode> mainQ = new LinkedList<>();
        mainQ.add(root);
        while (!mainQ.isEmpty()) {

            Queue<TreeNode> childQ = new LinkedList<>();
            while (!mainQ.isEmpty()) {
                TreeNode curr = mainQ.remove();
                System.out.print(curr.data + " ");
                for (TreeNode child : curr.children) {
                    childQ.add(child);
                }
            }
            System.out.println();
            mainQ = childQ;
        }
    }
//====================================================================================

    public static void levelOrderTraversal_LineWise2(TreeNode root) {
        Queue<TreeNode> mainQ = new LinkedList<>();
        Queue<TreeNode> childQ = new LinkedList<>();
        int level = 1;
        mainQ.add(root);
        while (!mainQ.isEmpty()) {
            TreeNode parent = mainQ.remove();
            System.out.print(parent.data + " ");
            for (TreeNode child : parent.children) {
                childQ.add(child);
            }
            if (mainQ.isEmpty()) {
                level++;
                System.out.println();
                mainQ = childQ;
                childQ = new LinkedList<>();
            }
        }
    }
//======================================================================

    public static void levelOrderTraversal_marker(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        int level = 1;
        while (!que.isEmpty()) {
            // TreeNode curr = que.remove();
            // if (curr == null) {
            //     System.out.println();
            //     if (que.isEmpty()) {
            //         break;
            //     }
            //     que.add(null);
            //     continue;
            // }
            // System.out.print(curr.data + " ");
            // for (TreeNode child : curr.children) {
            //     que.add(child);
            // }
            TreeNode curr = que.remove();
            if (curr != null) {
                System.out.print(curr.data + " ");
                for (TreeNode child : curr.children) {
                    que.add(child);
                }
            } else {
                level++;
                System.out.println();
                if (!que.isEmpty()) {
                    que.add(null);
                }
            }
        }
    }
    //=======================================================================================

    public static void levelOrderTraversal_linewise3(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            System.out.print("level : " + level + " => ");
            while (size-- > 0) {
                TreeNode curr = que.remove();
                System.out.print(curr.data + " ");
                for (TreeNode child : curr.children) {
                    que.add(child);
                }
            }
            level++;
            System.out.println();
        }
    }
//=================================================================================

    public static void zig_zag_traversal(TreeNode root) {
        int level = 1;
        Stack<TreeNode> mainSt = new Stack<>();
        Stack<TreeNode> childSt = new Stack<>();
        mainSt.push(root);
        while (!mainSt.isEmpty()) {

            TreeNode topNode = mainSt.pop();
            System.out.print(topNode.data + " ");
            if (level % 2 == 1) {
                for (int i = 0; i < topNode.children.size(); i++) {
                    TreeNode child = topNode.children.get(i);
                    childSt.push(child);
                }
            } else {
                for (int i = topNode.children.size() - 1; i >= 0; i--) {
                    TreeNode child = topNode.children.get(i);
                    childSt.push(child);
                }
            }
            if (mainSt.isEmpty()) {
                level++;
                System.out.println();
                mainSt = childSt;
                childSt = new Stack<>();
            }
        }

    }

    public static void main(String[] args) {
        int[] data = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, 110, -1, 120, -1, -1, 100, -1, -1, -1};
        TreeNode root = constructTree(data);
        // traverse(root);
        // levelOrderTraversal_Recursive(root);
        // levelOrderTraversal_Iterative(root);
        //levelOrderTraversal_LineWise1(root); => 2 queues mainQ,childQ (childQ is local)
        //levelOrderTraversal_LineWise2(root); => 2 queues mainQ,childQ are global
        //levelOrderTraversal_marker(root); => using marker as null after every level
        //levelOrderTraversal_linewise3(root); // using single queue with size
        zig_zag_traversal(root);
    }
}
