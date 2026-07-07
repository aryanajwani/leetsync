class Pair{
    String word; 
    int level;

    Pair(String word, int level){
        this.word = word;
        this.level =level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 0));

        int n = beginWord.length();

        while(!queue.isEmpty()){
            Pair node = queue.remove();
            String word = node.word;
            int level = node.level;
            
            for(int i=0; i<n; i++){
                String prev = word.substring(0, i);
                String next = word.substring(i+1);

                for(int j=0; j<26; j++){
                    char chr = (char)(j+'a');
                    String nWord = prev+ chr+ next;

                    if(set.contains(nWord)){
                        if(nWord.equals(endWord)) return level+2;

                        queue.add(new Pair(nWord, level+1));
                        set.remove(nWord);
                    }
                }  
            }
        }

        return 0;
    }
}