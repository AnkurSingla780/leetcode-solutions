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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>() ;
        List<List<Integer>> ans = new ArrayList<>() ;
        if(root==null){return ans ;}
        qu.offer(root) ;
        

        while(!qu.isEmpty()){
            int size = qu.size() ;
            List<Integer> list = new ArrayList<>() ;
            for(int i = 0 ;i<size ;i++){
                if(qu.peek().left!=null){qu.offer(qu.peek().left);} 
                if(qu.peek().right!=null){qu.offer(qu.peek().right);} 
                list.add(qu.poll().val) ;
            } 
            ans.add(list) ;
        }
        return ans ;
    }
}