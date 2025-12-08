class Solution {
    public int characterReplacement(String s, int k) {
        /* Variable to store the maximum
        length of substring found*/
        int maxLen = 0;
        
        /* Variable to track the maximum frequency
        of any single character in the current window*/
        int maxFreq = 0;
        
        // Pointers to maintain the current window [l, r]
        int l = 0, r = 0;
        
        // Hash array to count frequencies of characters
        int[] hash = new int[26];

        // Iterate through each starting point of substring
        while (r < s.length()) {
            /* Update frequency of current
            character in the hash array*/
            hash[s.charAt(r) - 'A']++;
            
            // Update max frequency encountered
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            
            // Check if current window is invalid
            while ((r - l + 1) - maxFreq > k) {
                /* Slide the left pointer to 
                make the window valid again*/
                hash[s.charAt(l) - 'A']--;
                
                // Recalculate maxFreq for current window
                maxFreq = 0;
                for (int i = 0; i < 26; ++i) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                
                // Move left pointer forward
                l++;
            }
            
            /* Update maxLen with the length 
            of the current valid substring*/
            maxLen = Math.max(maxLen, r - l + 1);
            
            // Move right pointer forward to expand window
            r++;
        }

        /* Return the maximum length of substring
        with at most k characters replaced*/
        return maxLen;
    }
}