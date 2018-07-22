// It is a good Trie example
// But in practis not using Array But using HashMap

class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node =root;
        for (int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i=0;i < word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.get(c);
        }
        if (!node.isEnd()){
            return false;
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i=0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}


class TrieNode {
    
    private TrieNode[] links;
    
    private final int R =26;
    
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }
    
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    
    public void put(char ch, TrieNode node){
        links[ch-'a']=node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */