public class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        int i = 0, e = len - 1;
        // skip the spaces at the front and the back
        while (i <= e && s.charAt(i) == ' ') i++;
        if (i > len - 1) return false;
        while (e >= i && s.charAt(e) == ' ') e--;
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        
        boolean num = false; // is digit
        boolean dot = false; // is a '.' ever appears
        boolean exp = false; // is a 'e' ever appears
        
        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            }
            else if (c == '.') {
                if(exp || dot) return false;
                dot = true;
            }
            else if (c == 'e') {
                if(exp || num == false) return false;
                exp = true;
                num = false;
            }
            else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return false;
            }
            else {
                return false;
            }
            i++;
        }
        return num;
    }
}