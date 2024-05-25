public class Main {
    public static void main(String[] args) {
        BST<Character> tree = new BST<Character>();

        tree.insert('F');
        tree.insert('E');
        tree.insert('H');
        tree.insert('D');
        tree.insert('G');
        tree.insert('C');
        tree.insert('B');
        tree.insert('H');
        tree.insert('K');
        tree.insert('J');

        tree.traverseInorder();

        System.out.println();

        tree.search('K');
        tree.search('A');

        tree.traverseInorder();
    }
}
