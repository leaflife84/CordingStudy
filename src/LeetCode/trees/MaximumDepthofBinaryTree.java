package LeetCode.trees;

public class MaximumDepthofBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int max = 0;
    public static void main(String[] args) {
        MaximumDepthofBinaryTree m = new MaximumDepthofBinaryTree();
        int node[] = {1,2,3,4,5,6};
        TreeNode root7 = new TreeNode(7,null,null);
        TreeNode root15 = new TreeNode(15,null,null);
        TreeNode root20 = new TreeNode(20,root15,root7);
        TreeNode root9 = new TreeNode(3,null,null);
        TreeNode root3 = new TreeNode(1,root9,root20);
        System.out.println(m.maxDepth(root3));

    }

    public int maxDepth(TreeNode root) {
        depth(root,1);
        return max;
    }

    public void depth(TreeNode root, int depth){
        if(root == null){
            return;
        }
        depth(root.left, depth+1);
        depth(root.right, depth+1);
        max = Math.max(max,depth);
    }
}
