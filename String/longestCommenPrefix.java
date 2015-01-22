public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int index = 0;
            for(; index < prefix.length(); index++){
                if(strs[i].length() - 1 < index || (strs[i].charAt(index) != prefix.charAt(index))){
                    break;
                }
            }
            prefix = prefix.substring(0,index);
        }
        return prefix;
    }
    
    private void trimPrefix(String p, String s){
        
    }
    
}