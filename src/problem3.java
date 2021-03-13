/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root)
which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class problem3 {

    public static StringBuilder sb;
    public static String serializeBinaryTree(Node root) {
            sb = new StringBuilder();
            serializeBinaryTreeHelper(root);

            return sb.toString();
        }

        private static void serializeBinaryTreeHelper(Node root) {
            if (root == null) {
                sb.append("null").append(",");
                return;
            }

            sb.append(root.val).append(",");
            serializeBinaryTreeHelper(root.left);
            serializeBinaryTreeHelper(root.right);
        }

        public static Node deserializeBinaryTree(String serialized) {
            if (serialized.length() == 0) {
                return null;
            }

            Queue<String> queue = new LinkedList<>(Arrays.asList(serialized.split(",")));

            return deserializeBinaryTreeHelper(queue);
        }

        private static Node deserializeBinaryTreeHelper(Queue<String> queue) {
            String val = queue.remove();
            if (val.equals("null")) {
                return null;
            }

            Node node = new Node(Integer.parseInt(val));
            node.left = deserializeBinaryTreeHelper(queue);
            node.right = deserializeBinaryTreeHelper(queue);

            return node;
        }
    private static class Node
    {
        Node left,right;
        int val;
        public Node(int val)
        {
            this.val=val;
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.right = new Node(4);

        String serialized= serializeBinaryTree(root);
        System.out.println(serialized);

        Node deserialized_root = deserializeBinaryTree(serialized);

        assert deserialized_root != null;
        System.out.println(deserialized_root.left.left.val);



    }
}
