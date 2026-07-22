/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>() ;
        // solve(root,list) ;
        if (root == null) {
            return list;
        }

        Stack<TreeNode> st = new Stack<>() ;
        
        TreeNode node = root ;
        while(node!=null || !st.isEmpty()){
            
            while(node!=null) {st.push(node) ;
            node = node.left ;}

            node=st.pop() ;
            list.add(node.val);
            
            node = node.right ;
            

        }
       return list ;
    }

    // public void solve(TreeNode root,List<Integer> list){
    //      if(root == null ){
    //         return ;
    //     }

    //     solve(root.left,list) ;
    //     list.add(root.val) ;
    //     solve(root.right,list) ;
        
    // }
}