public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        // break old string into string array
        String[] array = s.split(" ");
        
        // assemble the StringBuilder
        StringBuilder sb = new StringBuilder();
        
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")){
                sb.append(array[i]);
                sb.append(" ");
            }
        }
        
        // remove the last " "
        if(sb.length() == 0){
            return " "; // if input is " " or "  " or "   "
        }else{
            return sb.substring(0, sb.length() - 1);
        }
    }
    
}