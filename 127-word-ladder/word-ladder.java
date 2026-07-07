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

            if(word.equals(endWord)) return level+1;

            char[] charArray = word.toCharArray();
            for(int i=0; i<n; i++){
                char old = charArray[i];

                for(char chr= 'a'; chr<='z'; chr++){
                    charArray[i] = chr;
                    String nWord = new String(charArray);

                    if(set.contains(nWord)){
                        queue.add(new Pair(nWord, level+1));
                        set.remove(nWord);
                    }
                }
                charArray[i] = old;  
            }
        }

        return 0;
    }
}