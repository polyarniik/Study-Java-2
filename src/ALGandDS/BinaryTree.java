package ALGandDS;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    private Node head;

    public BinaryTree(int value) {
        this.head = new Node(value);
    }

    public void add(int value) {
        add(head, value);
    }

    public void add(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) add(node.left, value);
            else node.setLeft(new Node(value));
        } else if (node.right != null) add(node.right, value);
        else node.setRight(new Node(value));
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

    public void dfs() {
        dfs(head);
    }


    private void dfs(Node node) {
        if (node != null) {
            System.out.println(node);
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }


    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);

        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
