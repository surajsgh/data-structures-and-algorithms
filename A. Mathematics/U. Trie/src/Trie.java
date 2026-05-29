class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }

    public void put(char ch, Node node) {
        links[ch-'a'] = node;
    }

    public Node get(char ch) {
        return links[ch-'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }

    public void add(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("hel");
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("ab"));
        System.out.println(trie.startsWith("hel"));
    }
}
