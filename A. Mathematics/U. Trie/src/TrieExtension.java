class TreeNode {
    public TreeNode[] links = new TreeNode[26];
    public int counterEndWith = 0;
    public int counterPrefix = 0;

    public boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }

    public TreeNode get(char ch) {
        return links[ch-'a'];
    }

    public void put(char ch, TreeNode node) {
        links[ch-'a'] = node;
    }

    public void increaseCounterPrefix() {
        counterPrefix++;
    }

    public void increaseCounterEndWith() {
        counterEndWith++;
    }

    public int getEnd() {
        return counterEndWith;
    }

    public int getPrefixCounter() {
        return counterPrefix;
    }

    public void decreasePreficCounter() {
        counterPrefix--;
    }

    public void decreaseEndCounter() {
        counterEndWith--;
    }
}

public class TrieExtension {
    TreeNode root;

    public TrieExtension() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TreeNode());
            }
            node = node.get(ch);
            node.increaseCounterPrefix();
        }
        node.increaseCounterEndWith();
    }

    public int getCounterForWord(String word) {
        TreeNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getEnd();
    }

    public int getPrefixCounter(String word) {
        TreeNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getPrefixCounter();
    }

    public void erase(String word) {
        TreeNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return;
            }
            node = node.get(ch);
            node.decreasePreficCounter();
        }
        node.decreaseEndCounter();
    }

    public static void main(String[] args) {
        TrieExtension trie = new TrieExtension();
        trie.insert("hello");
        trie.insert("hello");
        trie.insert("hey");
        System.out.println(trie.getPrefixCounter("he"));
        System.out.println(trie.getCounterForWord("hey"));
        trie.erase("hey");
        System.out.println(trie.getCounterForWord("hey"));
    }
}
