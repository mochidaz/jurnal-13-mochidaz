public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int compareTo(Node<T> o) {
        return getData().compareTo(o.getData());
    }
}