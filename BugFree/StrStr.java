public class Solution {
    public int strStr(String haystack, String needle) {
        int l2 = needle.length();
        int l1 = haystack.length();
        if(l2 > l1){
            return -1;
        }
        if(l2 == 0){
            return 0;
        }
        
        if(l1 == 0){
            return -1;
        }
        
        for(int i = 0; i <= l1 - l2; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int start = i;
                int cursor1 = start;
                int cursor2 = 0;
                while(haystack.charAt(cursor1) == needle.charAt(cursor2)){
                    
                    cursor1++;
                    cursor2++;
                    
                    if(cursor2 == l2){
                        return start;
                    }
                }
            }
        }
        
        return -1;
    }
}