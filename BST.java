public class BST<T extends Comparable<T>> {
    public Node<T> root;

    public BST() {
        this.root = null;
    }

    public void insert(T value) {
        //this.root = insertRec(this.root, value);
        insertIter(value);
    }

    private void insertIter(T value) {
        Node<T> ptr = root;
        Node<T> parent = null;

        if (ptr == null) {
            root = new Node<T>(value);
            return;
        }

        while (ptr != null) {
            if (value.compareTo(ptr.getData()) <= 0) {
                parent = ptr;
                ptr = ptr.left;

                if (parent.left == null) {
                    parent.left = new Node<T>(value);
                    return;
                }
            } else {
                parent = ptr;
                ptr = ptr.right;

                if (parent.right == null) {
                    parent.right = new Node<T>(value);
                    return;
                }
            }
        }
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            root = new Node<T>(value);
            return root;
        }

        if (value.compareTo(root.getData()) <= 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.getData()) > 0) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public void traverseInorder() {
        traverseInorderRec(this.root);
    }

    private void traverseInorderRec(Node<T> root) {
        if (root != null) {
            traverseInorderRec(root.left);
            System.out.print(root.getData() + " ");
            traverseInorderRec(root.right);
        }
    }

    public void search(T value) {
        //Node<T> result = searchRec(this.root, value);
        Node<T> result = searchIter(value);

        if (result == null) {
            System.out.println("Data tidak ditemukan");
            return;
        }

        System.out.println("Data ditemukan");
    }

    private Node<T> searchRec(Node<T> root, T value) {
        if (root == null) {
            return root;
        }

        if (root.getData().equals(value)) {
            return root;
        }

        if (value.compareTo(root.getData()) <= 0) {
            root = searchRec(root.left, value);
        } else {
            root = searchRec(root.right, value);
        }

        return root;
    }

    private Node<T> searchIter(T value) {
        Node<T> ptr = root;

        while (ptr != null) {
            if (ptr.getData().equals(value)) {
                return ptr;
            }

            if (value.compareTo(ptr.getData()) <= 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }

        return null;
    }

    public boolean delete(T value) {
        return deleteIter(value);
    }

    public boolean deleteIter(T value) {
        Node<T> ptr = root;
        Node<T> parent = null;
    
        while (ptr != null) {
            if (value.compareTo(ptr.getData()) < 0) {
                parent = ptr;
                ptr = ptr.left;
            } else if (value.compareTo(ptr.getData()) > 0) {
                parent = ptr;
                ptr = ptr.right;
            } else {
                if (ptr.left != null) {
                    Node<T> leftMax = findMax(ptr.left);

                    ptr.data = leftMax.data;
                    parent = ptr;
                    ptr = ptr.left;
                }

                if (ptr.right != null) {
                    Node<T> rightMin = findMin(ptr.right);

                    ptr.data = rightMin.data;
                    parent = ptr;
                    ptr = ptr.right;
                } else {
                    if (parent == null) {
                        root = null;
                    } else if (parent.left == ptr) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }

                    return true;
                
                }
            }
        }
    
        return false;
    }
    
    private Node<T> findMin(Node<T> root) {
        Node<T> ptr = root;

        while (ptr.left != null) {
            ptr = ptr.left;
        }

        return ptr;
    }

    private Node<T> findMax(Node<T> root) {
        Node<T> ptr = root;

        while (ptr.right != null) {
            ptr = ptr.right;
        }

        return ptr;
    }
}