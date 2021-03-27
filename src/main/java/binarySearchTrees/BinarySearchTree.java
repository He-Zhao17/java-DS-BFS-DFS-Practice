package binarySearchTrees;

import stacksQueues.ListStack;
import stacksQueues.QueueImplementation;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.util.ArrayList;
import java.util.Stack;

/** Implementation of a binary search tree.
 *  The course has been modified from the code of Prof. Galles.
 */
class BinarySearchTree {

    private BSTNode root; // the root of the tree

    /**
     * An inner class representing a node in a BST tree
     */
    private class BSTNode {
        public char data; // value stored at the node
        public BSTNode left; // left subtree
        public BSTNode right;  // right subtree

        BSTNode(char newdata) {
            data = newdata;
        }
    }



    /** Return a string that contains values of the nodes, traversed using postorder traversal.
     */
    public String getNodesInPostorder() {
        return getNodesInPostorder(root);
    }

    /**
     * Insert a given element into the BST tree
     */
    public void insert(char elem) {
        root = insert(root, elem);
    }


    /** Return a string that contains values of the nodes, traversed using postorder traversal.
     *
     * @param root root of the tree
     */
    private String  getNodesInPostorder(BSTNode root) {
        StringBuilder s = new StringBuilder();
        // FILL IN CODE
        // Must be recursive
        ListStack stack = new ListStack();
        StringBuilder res = new StringBuilder();
        BSTNode curr = root;
        stack.push(curr);
        curr = curr.left;
        while (stack.empty()) {
            if (curr == null) {
                BSTNode temp = (BSTNode) stack.pop();
                res.append(temp.data);
                curr = temp.right;
            }
            stack.push(curr);
            curr = curr.left;
        }
        return res.toString();
        //return s.toString();
    }

    /**
     * A method that changes a binary search tree so that it is "balanced",
     * using the following simple algorithm:
     * Put all the values from the tree into an ArrayList, "in order"
     * Create an empty tree and insert the elements into the tree one by one so that
     * the tree is balanced. (Hint: First insert the element in the middle of the array,
     * and then recursively insert other elements).
     * Resets the root.
     */
    public void makeBalanced() {
        // FILL IN CODE
        ListStack stack = new ListStack();
        ArrayList<Character> res = new ArrayList<Character>();
        BSTNode curr = root;
        stack.push(curr);
        curr = curr.left;
        while (stack.empty()) {
            if (curr == null) {
                BSTNode temp = (BSTNode) stack.pop();
                res.add(temp.data);
                curr = temp.right;
            }
            stack.push(curr);
            curr = curr.left;
        }

        root.data =




    }

    public BSTNode (ArrayList<Character> arr) {
        BSTNode res = new BSTNode(arr.get((arr.size() - 1) / 2));
    }



    /**
     * Insert elem into the tree with the given root
     */
    private BSTNode insert(BSTNode tree, char elem) {
        if (tree == null) {
            return new BSTNode(elem);
        }
        if (elem < tree.data) {
            tree.left = insert(tree.left, elem);
            return tree;
        } else {
            tree.right = insert(tree.right, elem);
            return tree;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert('f');
        bst.insert('a');
        bst.insert('m');
        bst.insert('z');
        bst.insert('b');
        bst.insert('p');
        bst.insert('w');

        String s = bst.getNodesInPostorder();
        System.out.println(s);

        bst.makeBalanced();

        s = bst.getNodesInPostorder();
        System.out.println(s);
    }

}

