package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {


    }

    public void leverOrderTraversal(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }

    }
}
