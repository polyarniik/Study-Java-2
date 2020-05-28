package ALGandDS;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class AVLTree {
    private Node head;

    public AVLTree(int value) {
        this.head = new Node(value);
    }

    public void add(int key) {
        head = add(head, key);
    }

    private Node add(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = add(node.left, key);
        else node.right = add(node.right, key);
        return balance(node);
    }

    private Node balance(Node node) {
        fixHeight(node);
        if (bFactor(node) == 2) {
            if (bFactor(node.right) < 0) node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        if (bFactor(node) == -2) {
            if (bFactor(node.left) > 0) node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        return node;
    }

    private void fixHeight(Node node) {
        int left = node.left == null ? 0 : node.left.height;
        int right = node.right == null ? 0 : node.right.height;
        node.height = Math.max(left, right) + 1;
    }


    private int bFactor(Node node) {
        int left = node.left != null ? node.left.height : 0;
        int right = node.right != null ? node.right.height : 0;
        return right - left;
    }

    private Node rightRotate(Node node) {
        Node q = node.left;
        node.left = q.right;
        q.right = node;
        fixHeight(node);
        fixHeight(q);
        return q;
    }

    private Node leftRotate(Node node) {
        Node q = node.right;
        node.right = q.left;
        q.left = node;
        fixHeight(node);
        fixHeight(q);
        return q;
    }

    public Node findMin(Node node) {
        return node.left != null? findMin(node.left): node;
    }

    public Node removeMin(Node node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return balance(node);
    }

    public Node remove(int value){
        return this.head = remove(head,value);
    }


    private Node remove(Node node, int key){
        if (node == null){
            return null;
        }
        if (key < node.key){
            node.left = remove(node.left, key);
        } else if (key > node.key){
            node.right = remove(node.right, key);
        } else {
            Node l = node.left;
            Node r = node.right;
            if (r == null) return l;
            Node min = findMin(r);
            min.right = removeMin(r);
            min.left = l;
            return balance(min);
        }
        return balance(node);
    }

    private void dfs(Node node) {
        if (node != null) System.out.println(node);
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);

    }

    public void bfs() {
        Queue<Node> ll = new LinkedList<>();
        ll.add(head);
        while (!ll.isEmpty()) {
            Node node = ll.remove();
            System.out.println(node);
            if (node.left != null) ll.add(node.left);
            if (node.right != null) ll.add(node.right);
        }
    }

    private class Node {
        private int key;
        private int height;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    height == node.height &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, height, left, right);
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }
}
