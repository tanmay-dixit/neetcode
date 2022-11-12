package trees.easy;

import trees.TreeNode;

public class MaxDepth {

  class Solution {

    public int maxDepthBottomUp(TreeNode node) {

      if (node == null) {
        return 0;
      }

      int leftDepth = 1 + maxDepthBottomUp(node.left);
      int rightDepth = 1 + maxDepthBottomUp(node.right);

      return Math.max(leftDepth, rightDepth);

    }

  }
}
