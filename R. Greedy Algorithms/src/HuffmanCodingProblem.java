//  Solve this problem in two steps as shown here:
//  1. Build a binary tree
//  2. Traverse the binary tree

import java.util.PriorityQueue;

class HuffmanNode {
    char ch;
    int num;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char ch, int num, HuffmanNode left, HuffmanNode right) {
        this.ch = ch;
        this.num = num;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanCodingProblem {
    public static void main(String[] args) {
        int[] num = { 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] ch = { 5, 9, 12, 13, 16, 45 };
        printHuffmanCodes(ch, num);
    }

    //  Time Complexity : O(nlogn)
    private static void printHuffmanCodes(char[] ch, int[] num) {
        int n = ch.length;
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>((n1, n2) -> n1.num-n2.num);

        for (int i=0; i<n; i++) {
            queue.add(new HuffmanNode(ch[i], num[i], null, null));
        }

        HuffmanNode root = null;

        while (queue.size() > 1) {
            HuffmanNode first = queue.poll();
            HuffmanNode second = queue.poll();
            HuffmanNode node = new HuffmanNode('$', first.num+ second.num, first, second);
            root = node;
            queue.add(new HuffmanNode('$', first.num+ second.num, first, second));
        }

        printRec(root, "");
    }

    private static void printRec(HuffmanNode node, String str) {
        if (node.ch!='$') {
            System.out.println(node.ch + " " + str);
            return;
        }
        printRec(node.left, str + "0");
        printRec(node.right, str + "1");
    }
}
