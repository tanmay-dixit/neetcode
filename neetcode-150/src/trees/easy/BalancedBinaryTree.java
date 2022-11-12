package trees.easy;

import trees.TreeNode;

public class BalancedBinaryTree {

  class Solution {

    private boolean isBalanced;

    public boolean isBalanced(TreeNode root) {
      isBalanced = true;
      depthOf(root);
      return isBalanced;
    }

    private int depthOf(TreeNode currentNode) {

      if (currentNode == null) {
        return 0;
      }

      int leftDepth = 1 + depthOf(currentNode.left);
      int rightDepth = 1 + depthOf(currentNode.right);

      if (Math.abs(leftDepth - rightDepth) > 1) {
        isBalanced = false;
      }

      return Math.max(leftDepth, rightDepth);

    }

  }

}
