package easy.October;

import easy.TreeNode;

class problem112{
    
    public static void main(String[] args) {
        
        TreeNode example1 = new TreeNode();
        TreeNode example2 = new TreeNode();
        TreeNode example3 = new TreeNode();

        System.out.println( hasPathSum(example1, 0));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        
        //If the node given DNE, then we instantly return null since we are out of bounds
        if(root == null)
            return false;
        
        //We have reached leaf node, so we will check if val matches targetSum
        if(root.left == null && root.right == null)
            return targetSum == root.val;
        
        //Check left and right nodes to see if one child node has achieved base cases
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
