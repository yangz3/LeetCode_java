public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null) {
            return 0;
        }
        // first filter out all white spaces
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        int index = 0;
        
        // parse the sign
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        // add up the value part
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
        }
        
        // check overflow
        if (num * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}