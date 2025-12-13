class Solution {
    public boolean canJump(int[] arr) {
        int maxAllowed =0;
        for (int i=0; i<arr.length; i++){
            if (i > maxAllowed) return false;
            
            maxAllowed = Math.max(maxAllowed, i+arr[i]);
            if (maxAllowed >= arr.length-1) return true;
            
        }

        return false;
    }
}