package LeetCode;

import LeetCode.dfs.MaximumTree;

import java.util.HashSet;
import java.util.Set;

public class TwoSum4 {

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

    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        TwoSum4 t = new TwoSum4();
        //root = [5,3,6,2,4,null,7], k = 9
        TreeNode root4 = new TreeNode(4,null,null);
        TreeNode root7 = new TreeNode(7,null,null);
        TreeNode root6 = new TreeNode(6,null,root7);
        TreeNode root2 = new TreeNode(2,null,null);
        TreeNode root3 = new TreeNode(3,root2,root4);
        TreeNode root5 = new TreeNode(5,root3,root6);
        System.out.println(t.findTarget(root5,16));
        System.out.println("1");
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findNode(root, k ,set);
    }

    public boolean findNode(TreeNode node, int k, Set<Integer> set){
        if(node == null){
            return false;
        }
        if(findNode(node.left,k,set)){
            return true;
        }
        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);

        if(findNode(node.right,k,set)){
            return true;
        }

        return false;
    }
}
