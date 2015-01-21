/*
 
 Given two binary strings, return their sum (also a binary string).
 
 For example,
 a = "11"
 b = "1"
 Return "100".
 
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        int i = 0;
        int carry = 0;
        while(a.length() > i && b.length() > i){
            int digit = (carry + (a.charAt(i) - '0') + (b.charAt(i) - '0') ) % 2;
            carry = (carry + (a.charAt(i) - '0') + (b.charAt(i) - '0') ) / 2;
            builder.insert(0,digit);
            i++;
        }
        
        while(a.length() > i){
            int digit = (carry + (a.charAt(i) - '0')  ) % 2;
            carry = (carry + (a.charAt(i) - '0')  ) / 2;
            builder.insert(0,digit);
            i++;
        }
        
        while(b.length() > i){
            int digit = (carry +  (b.charAt(i) - '0') ) % 2;
            carry = (carry +  (b.charAt(i) - '0') ) / 2;
            builder.insert(0,digit);
            i++;
        }
        
        // check carry
        if(carry != 0){
            builder.insert(0,1);
        }
        
        return builder.toString();
    }
}