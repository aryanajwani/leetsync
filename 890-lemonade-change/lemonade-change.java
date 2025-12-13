class Solution {
    public boolean lemonadeChange(int[] arr) {
        int change[] = new int[]{0, 0, 0};
        for(int i=0; i<arr.length; i++){
            if(arr[i]== 5) ++change[0];

            else if(arr[i]==10){
                if(change[0] == 0) return false;
                else{
                    ++change[1];
                    --change[0];
                }
            }

            else if(arr[i]==20){
                //return 15
                if(change[0] ==0) return false;

                if((change[1]>=1 && change[0]>=1 )){
                    ++change[2];
                    --change[1];
                    --change[0];
                }
                else if(change[0] >= 3) {
                    ++change[2];
                    change[0] -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}