package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {
    private Node root;

    private static class Node {
        String key;
        Integer value;
        Integer height;

        //        List<Node> children;
        Node left;
        Node right;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    public Integer get(String key) { // O(log n) if tree is balanced, O(n) if tree is not balanced
        Node current = root;

        while (current != null) {
            int result = key.compareTo(current.key);
            if (result == 0) return  current.value;
            else if (result < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public void add(String key, Integer value) {
        root = add(root, key, value);
    }

    private Node add(Node current, String key, Integer value) { // O(log n) if tree is balanced, O(n) if tree is not balanced
        if (current == null) {
            current = new Node(key, value);
        } else {
            int result = key.compareTo(current.key);
            if (result == 0) current.value = value;
            else if (result < 0) current.left = add(current.left, key, value);
            else current.right = add(current.right, key, value);
            current.height = 1 + Math.max((current.left == null) ? 0 : current.left.height,
                    (current.right == null) ? 0 : current.right.height);
        }
        return current;
    }

    public Iterable<String> getAllKeys(){ // O(n)
        Queue<String> queue = new LinkedList<>();
        inorder(queue, root);
        return queue;
    }

    private void inorder(Queue<String> queue, Node current) {
        if (current.left != null) inorder(queue, current.left);
        queue.add(current.key);
        if (current.right != null) inorder(queue, current.right);
    }

    // O(n log(n)) time complexity
    // O(n) space complexity
    public static String[] sortWithTree(String[] data) {
        SearchTree tree = new SearchTree(); // O(1)
        for (String s : data) { // O(n log(n))
            tree.add(s, 0); // O(log n)
        }
        Iterable<String> keys = tree.getAllKeys(); // O(n)
        String[] sortedData = new String[data.length];
        int i = 0;
        for (String s : keys) { // O(n)
            sortedData[i++] = s;
        }
        return sortedData;
    }

    public String getMaxKey(){ // O(log n) if tree is balanced, O(n) if tree is not balanced
        Node current = root;
        while (current != null) {
            if (current.right == null) return current.key;
            current = current.right;
        }
        return null;
    }

    public String searchByValueBFS(Integer value) { // O(n)
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.value.equals(value)) return current.key;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return null;
    }

    public String searchByValueDFS(Integer value) { // O(n)
        return searchByValueDFS(value, root);
    }

    private String searchByValueDFS(Integer value, Node current) {
        if (current == null) return null;
        if (current.value.equals(value)) return current.key;
        String result = searchByValueDFS(value, current.left);
        if (result == null) result = searchByValueDFS(value, current.right);
        return result;
    }

    public int treeHeight() { // O(n)
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                Node current = queue.remove();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            height++;
        }
        return height;
    }

    public int treeHeight2() { // O(1)
        return (root == null) ? 0 : root.height;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) { //O(n)
        if (node == null)  return true;

        int leftHeight = (node.left == null) ? 0 : node.left.height;
        int rightHeight = (node.right == null) ? 0 : node.right.height;

        int balanceFactor = Math.abs(leftHeight - rightHeight);

        if (balanceFactor > 1) return false;

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.add("C", 10);
        tree.add("A", 20);
        tree.add("B", 30);
        tree.add("D", 40);
        tree.add("G", 90);

        // Если добавлять ключи последовательно, несбалансированное дерево поиска выродится в связный список
        // A -> B -> C -> D -> E

        System.out.println(tree.get("A"));
        System.out.println(tree.get("B"));
        System.out.println(tree.get("C"));
        System.out.println(tree.get("D"));
        System.out.println(tree.get("G"));
        System.out.println(tree.get("X"));

        System.out.println(tree.getAllKeys());

        String[] sorted = sortWithTree(new String[]{"Hello", "World", "C", "D", "A"});
        System.out.println(Arrays.toString(sorted));

        System.out.println("Max key = " + tree.getMaxKey());

        System.out.println("searchByValueBFS: " + tree.searchByValueBFS(90));
        System.out.println("searchByValueDFS, inorder: " + tree.searchByValueDFS(90));
        System.out.println("treeHeight: " + tree.treeHeight());
        System.out.println("treeHeight2: " + tree.treeHeight2());

        System.out.println("Is the tree balanced? " + tree.isBalanced());
    }

}
