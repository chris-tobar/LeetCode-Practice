package medium.October;

import medium.TreeNode;

class problem623{
    
    public static void main(String[] args) {
        
        String[] example1 = {"4","2","6","3","1","5"};
        String[] example2 = {"4","2","","3","1"};
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {

        //Base case for if the depth is already 1, then we want to place new node as the new root
        if(depth == 1)
        {
            TreeNode sol = new TreeNode(val);
            sol.left = root;
            return sol;
        }
        //Traverse with BFS with depth-1, since we want to reach the parent nodes to insert the new nodes
        BFS(root, val, depth-1);
        return root;
    }
    
    public static void BFS(TreeNode root, int val, int depth)
    {
        //Recursive base case that node is null
        if(root == null)
            return;
        //We have reached the depth that we are searching for
        if(depth <=1)
        {
            //Create the left and right nodes of the desired node
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);

            //Assign temp pointers for the left and right nodes
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            
            //Assign parent node the new node 
            root.left = left;
            root.right = right;
            
            //Reappend the temp pointers to new nodes added
            left.left = tempLeft;
            right.right = tempRight;
        }
        else
        {
            //We haven't reached one of the cases above, so keep recursively searching the left
            // and right nodes
            BFS(root.left, val, depth-1);
            BFS(root.right, val, depth-1);
        }
    }
}
