package easy.October;

import easy.TreeNode;

class problem112{
    
    public static void main(String[] args) {
        
        TreeNode example1 = new TreeNode();
        TreeNode example2 = new TreeNode();
        TreeNode example3 = new TreeNode();
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null)
            return targetSum == root.val;
        
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
