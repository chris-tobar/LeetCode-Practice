package medium.October;

import medium.TreeNode;

class problem623{
    
    public static void main(String[] args) {
        
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth == 1)
        {
            TreeNode sol = new TreeNode(val);
            sol.left = root;
            return sol;
        }
        BFS(root, val, depth-1);
        return root;
    }
    
    public static void BFS(TreeNode root, int val, int depth)
    {
        if(root == null)
            return;
        if(depth <=1)
        {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            
            root.left = left;
            root.right = right;
            
            left.left = tempLeft;
            right.right = tempRight;
        }
        else
        {
            BFS(root.left, val, depth-1);
            BFS(root.right, val, depth-1);
        }
    }
}
