package trees.easy;

import trees.TreeNode;

public class InvertTree {

    class Solution {

        public TreeNode invertTree(TreeNode currentNode) {

            // end condition for recursion
            if (currentNode == null) {
                return null;
            }

            // swap
            var newNode = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = newNode;

            // invert each subtree recursively
            invertTree(currentNode.left);
            invertTree(currentNode.right);

            return currentNode;

        }

    }
}