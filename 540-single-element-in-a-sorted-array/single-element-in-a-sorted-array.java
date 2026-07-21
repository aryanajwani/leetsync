class Solution {
    public int singleNonDuplicate(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while(low <=high){
            int mid = low +(high-low)/2;
            // System.out.print(mid);

            boolean first;
            
            if((mid-1)>=0 && arr[mid-1] == arr[mid]) first = false;
            else if((mid+1)<arr.length && arr[mid+1] == arr[mid]) first = true;
            else return arr[mid];

            // System.out.println(first);

            if(first){
                if(mid%2==1) high = mid-1;
                else low = mid+1;
            }
            else {
                if(mid%2==0) high = mid-1;
                else low = mid+1;
            }
        }

        return -1;
    }
}