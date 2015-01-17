public class Solution {
    // brutal force
    /*
     public int lengthOfLongestSubstring(String s) {
     int max = 0;
     HashSet<Character> set = new HashSet<Character>();
     for(int i = 0; i < s.length(); i++){
     set.clear();
     set.add(s.charAt(i));
     int j = i - 1;
     while(j >= 0){
     if(!set.contains(s.charAt(j))){
     set.add(s.charAt(j));
     j--;
     }else{
     break;
     }
     }
     j++;
     max = Math.max(i - j + 1, max);
     }
     return max;
     }*/
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        
        // maintain a set which contains no duplicates
        // the boundary is from leftBound to the current i
        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    // remove the duplicate char and the chars on the left of that
                    // char to keep the set clean and of maximum length after the regulation
                    set.remove(s.charAt(leftBound));
                    leftBound ++;
                }
                leftBound ++;
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1);
            }
        }
        
        return max;
    }
    
    
}