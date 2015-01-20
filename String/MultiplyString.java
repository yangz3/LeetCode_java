public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] digits = new int[num1.length() + num2.length()];
        
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                digits[i + j] += a * b;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        for (int i = 0; i < digits.length; i++) {
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            sb.insert(0, digit);
        }
        
        //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
}