package Week_07;

public class Trie {
    private Trie[] next = null;
    private boolean isEnd;
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        for (int i = 0; i < word.length(); i ++) {
            if (curr.next[word.charAt(i) - 'a'] == null) {
                curr.next[word.charAt(i) - 'a'] = new Trie();
            }
            curr = curr.next[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }

    public Trie searchPrefix(String word) {
        if (word == null) {
            return null;
        }
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            node = node.next[word.charAt(i) - 'a'];
            if (node == null) {
                return  null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String word) {
        Trie node = searchPrefix(word);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
