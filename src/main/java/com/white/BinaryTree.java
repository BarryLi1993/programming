package com.white;

/*
二叉树结构如下：

    1
   / \
  2   3
 /   / \
4   5   6
 \     /
  7   8

*/

import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        // 构造一棵树
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        c.right = f;
        b.left = d;
        b.right = e;
        e.left = g;

        // 广度优先遍历（队列）
        breathLoop(root);

//        // 先序递归遍历
//        firstLoop(root);
//
//        // 先序遍历（栈）
//        firstLoopStack(root);

        mirror(root);

        breathLoop(root);
    }

    public static void breathLoop(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode headNode = queue.poll();
            System.out.print(headNode.val);
            if (headNode.left != null) {
                queue.offer(headNode.left);
            }
            if (headNode.right != null) {
                queue.offer(headNode.right);
            }
        }
    }

    public static void firstLoop(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            firstLoop(root.left);
            firstLoop(root.right);
        }
    }

    public static void firstLoopStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null) {
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    System.out.println(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    public static void mirror(TreeNode root) {
        if (root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }

    private static boolean hasNoLeafNode(TreeNode node) {
        if (node == null) {
            return true;
        } else if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

//    public static void breathLoop(TreeNode root) {
//        if (root != null) {
//            List<TreeNode> nodeList = new ArrayList<TreeNode>();
//            nodeList.add(root);
//            breathDeepLoop(nodeList);
//        }
//    }
//    public static void breathDeepLoop(List<TreeNode> nodeList){
//
//        if (nodeList != null && nodeList.size() > 0) {
//            List<TreeNode> newNodeList = new ArrayList<TreeNode>();
//            for (int i = 0; i < nodeList.size(); i++) {
//                TreeNode treeNode = nodeList.get(i);
//                System.out.println(treeNode.val);
//                if (treeNode.left != null) {
//                    newNodeList.add(treeNode.left);
//                }
//                if (treeNode.right != null) {
//                    newNodeList.add(treeNode.right);
//                }
//            }
//            breathDeepLoop(newNodeList);
//        }
//    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
