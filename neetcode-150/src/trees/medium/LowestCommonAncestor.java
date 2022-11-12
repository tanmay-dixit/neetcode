package trees.medium;

import trees.TreeNode;

public class LowestCommonAncestor {

    class Solution {

        // This solution is for a Binary Tree in general (NOT BST)
        public TreeNode lowestCommonAncestor(TreeNode currentNode,
                TreeNode p, TreeNode q) {

            // End condition for recursion - currentNode is null or matches p/q
            if (currentNode == null || currentNode == p || currentNode == q) {
                return currentNode;
            }

            var leftAncestor = lowestCommonAncestor(currentNode.left, p, q);

            // We have found LCA from the left side. No need to traverse right
            if (leftAncestor != null && leftAncestor != p && leftAncestor != q) {
                return leftAncestor;
            }

            var rightAncestor = lowestCommonAncestor(currentNode.right, p, q);

            if (leftAncestor != null && rightAncestor != null) {
                // Found LCA
                return currentNode;
            } else if (leftAncestor != null) {
                // Found only one matching node
                return leftAncestor;
            } else if (rightAncestor != null) {
                // Found only one matching node
                return rightAncestor;
            } else {
                // No matching nodes found
                return null;
            }

        }

    }
}
