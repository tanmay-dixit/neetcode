public class Main {
    public static void main(String[] args) {

        var bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        System.out.println("contains 18 = " + bst.contains(18));
        System.out.println("contains 0 = " + bst.contains(0));

        System.out.println("");
        System.out.println("BFS = " + bst.bfs());

        System.out.println("");
        System.out.println("DFS PreOrder Iterative = " + bst.dfsPreOrderIterative());
        System.out.println("DFS PreOrder Recursive = " + bst.dfsPreOrderIterative());

        System.out.println("");
        System.out.println("DFS PostOrder Recursive = " + bst.dfsPostOrderRecursive());

        System.out.println("");
        System.out.println("DFS Inorder Iterative = " + bst.dfsPreOrderIterative());

    }

}