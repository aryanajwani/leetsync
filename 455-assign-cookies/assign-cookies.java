class Solution {
    public int findContentChildren(int[] student, int[] cookie) {
        // int student[] = g.clone();
        //  int cookie[] = s.clone();
         Arrays.sort(student);
         Arrays.sort(cookie);

         int i=0, j=0;
         while(i<student.length && j<cookie.length){
            if(cookie[j] >= student[i]){
                i++;
            }
            j++;
         }

         return i;
    }
}