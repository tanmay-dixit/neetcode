public class Main {
    public static void main(String[] args) {
        var bst = new BinarySearchTree();
        System.out.println("empty contains 27 = " + bst.contains(27));

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);

        bst.insert(27);
        System.out.println("contains 18 = " + bst.contains(18));
        System.out.println("contains 18 = " + bst.contains(82));
        System.out.println("contains 0 = " + bst.contains(0));
        System.out.println("contains 100 = " + bst.contains(100));
    }
}