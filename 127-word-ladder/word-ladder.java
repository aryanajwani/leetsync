// class Pair{
//     String word; 
//     int level;

//     Pair(String word, int level){
//         this.word = word;
//         this.level =level;
//     }
// }
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        set.remove(beginWord);

        int n = beginWord.length();
        int level=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int k=0; k<size; k++){
                String word = queue.remove();

                if(word.equals(endWord)) return level+1;

                char[] charArray = word.toCharArray();
                for(int i=0; i<n; i++){
                    char old = charArray[i];

                    for(char chr= 'a'; chr<='z'; chr++){
                        charArray[i] = chr;
                        String nWord = new String(charArray);

                        if(set.contains(nWord)){
                            queue.add(nWord);
                            set.remove(nWord);
                        }
                    }
                    charArray[i] = old;  
                }
            }
            ++level;
        }

        return 0;
    }
}