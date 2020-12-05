package Tree;

public class TrieTree {
    private TrieNode root = new TrieNode('/');

    public void insert(char [] text){
        TrieNode p = root;
        for(int i=0;i<text.length;i++){
            int index = text[i]-'a';
            if(p.children[index]==null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char [] pattern){
        TrieNode p = root;
        for(int i=0;i<pattern.length;i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(p.isEndingChar == false) return false;
        else return true;
    }

    private class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("how".toCharArray());
        tree.insert("hi".toCharArray());
        tree.insert("her".toCharArray());
        tree.insert("hello".toCharArray());
        tree.insert("so".toCharArray());
        tree.insert("see".toCharArray());

        System.out.println(tree.find("hello".toCharArray()));
    }
}
