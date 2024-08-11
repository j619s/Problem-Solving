package Trees;

public class MaxPathSum {
    int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int x = dfs(root.left);
        int y = dfs(root.right);
        answer = Math.max(answer, x + y + root.val);
        return Math.max(0, root.val + Math.max(x, y));
    }
}
