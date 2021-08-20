package LeetCode.dfs;
//Maximum Product of Splitted Binary Tree


public class MaximumTree {

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

    static int node[] = {1,2,3,4,5,6};
    public static void main(String[] args) {

        MaximumTree m = new MaximumTree();
        int node[] = {1,2,3,4,5,6};
        TreeNode root4 = new TreeNode(4,null,null);
        TreeNode root5 = new TreeNode(5,null,null);
        TreeNode root6 = new TreeNode(6,null,null);
        TreeNode root2 = new TreeNode(2,root4,root5);
        TreeNode root3 = new TreeNode(3,root6,null);
        TreeNode root1 = new TreeNode(1,root2,root3);
        m.maxProduct(root1);
    }


    private long totalSum = 0;
    private long result = 0;

    public int maxProduct(TreeNode root) {
        dfs(root);
        cal(root);
        System.out.println((int)(result % ((int)Math.pow(10,9)+7)));
        return (int)(result % ((int)Math.pow(10,9)+7));

    }

    public void dfs(TreeNode root){
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        totalSum += (long)root.val;
    }

    public long cal(TreeNode root){
        if(root == null) {
            return 0;
        }
        long l = cal(root.left);
        long r = cal(root.right);
        long subTreeSum = root.val+l+r;
        result = Math.max(result, (subTreeSum) * (totalSum - subTreeSum));
        return subTreeSum;
    }


}
