package LeetcodeDailyJuly2024;

import Trees.TreeNode;

public class DirectionsFromABinaryTreeNode2096 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode four = new TreeNode(4);
        root.left = one;
        root.right = two;
        one.left = three;
        two.left = six;
        two.right = four;
        System.out.println(getDirections(root, 3, 6));

    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        
        String s = "ABC";
        String str = s.repeat(s.length());
        return str;

    }

    public static TreeNode lca(TreeNode root, int n1, int n2){

        if(root == null || root.val == n1 || root.val == n2) return root;

        TreeNode leftLCA = lca(root.left, n1, n2);
        TreeNode rightLCA = lca(root.right, n1, n2);

        if(leftLCA == null){
            return rightLCA;
        } else if(rightLCA == null){
            return leftLCA;
        } else {
            return root;
        }

    }
}
