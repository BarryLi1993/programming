package com.white;

public class LinkNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        printLinkNodes(node1);

//        Node reverse_node = reverse(node1);
//        System.out.print("reverse:");
//        printLinkNodes(reverse_node);

        System.out.print("reverse: 2 to 5");
        Node reverse_node = reverseFromTo(node1, 2, 5);
        printLinkNodes(reverse_node);
    }

    public static void printLinkNodes(Node rootNode) {
        while (rootNode != null) {
            System.out.print(rootNode.value + "->");
            rootNode = rootNode.next;
        }
    }

    public static Node reverseFromTo(Node rootNode, int m, int n) {
        Node temp_node = rootNode;
        if (rootNode != null && m < n && m > 0 && n > 0) {
            int index = 1;
            Node preNode = null;
            while (rootNode != null) {
                if (index == m) {
                    Node reversePreNode = null;
                    Node head_Node = rootNode;
                    while (rootNode != null && index <= n) {
                        // 记录当前节点的下一个节点
                        Node next = rootNode.next;

                        // 当前节点，指针指向前一个节点
                        rootNode.next = reversePreNode;

                        // 指针移动
                        reversePreNode = rootNode;
                        rootNode = next;
                        index++;
                    }
                    if (preNode != null) {
                        preNode.next = reversePreNode;
                        if (m == 1) {
                            temp_node = preNode;
                        }
                    }
                    if (rootNode != null) {
                        head_Node.next = rootNode;
                    }
                } else {
                    index++;
                    preNode = rootNode;
                    rootNode = rootNode.next;
                }
            }
        }
        return temp_node;
    }

    public static Node reverseNumber(Node rootNode, int number) {
        if (rootNode != null) {
            Node preNode = null;
            int index = 1;
            while (rootNode != null && index < number) {
                // 记录当前节点的下一个节点
                Node next = rootNode.next;

                // 当前节点，指针指向前一个节点
                rootNode.next = preNode;

                // 指针移动
                preNode = rootNode;
                rootNode = next;
                index++;
            }
            return preNode;
        } else {
            return rootNode;
        }
    }

    public static Node reverse(Node rootNode) {
        if (rootNode != null) {
            Node preNode = null;
            while (rootNode != null) {
                // 记录当前节点的下一个节点
                Node next = rootNode.next;

                // 当前节点，指针指向前一个节点
                rootNode.next = preNode;

                // 指针移动
                preNode = rootNode;
                rootNode = next;
            }
            return preNode;
        } else {
            return rootNode;
        }
    }
}

class Node {

    int value;
    Node next;

    public void setNext(Node node) {
        this.next = node;
    }

    Node(int val) {
        this.value = val;
    }
}
