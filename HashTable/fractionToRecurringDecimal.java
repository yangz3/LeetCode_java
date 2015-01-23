public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        
        String ans = "";
        
        // xor num and den to get the sign of result
        if ((numerator < 0) ^ (denominator < 0)) {
            ans += "-";
        }
        
        //convert to positive numbers，int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        //the integer portion of the result
        long res = num / den;
        ans += String.valueOf(res);
        
        //the remain of the result
        long rem = (num % den);
        if (rem == 0) return ans;
        
        // use hashmap to store the value of the remain and the position it occured
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        ans += ".";
        rem = rem * 10;
        
        while (rem != 0) {
          
            if (map.containsKey(rem)) {
                int beg = map.get(rem);
                String part1 = ans.substring(0, beg);
                String part2 = ans.substring(beg, ans.length());
                ans = part1 + "(" + part2 + ")";
                return ans;
            }
            
            
            map.put(rem, ans.length());  // ans.length() is the start point of the repeatation
            res = rem / den;
            ans += Long.toString(res);
            rem = (rem % den) * 10;
        }
        
        return ans;
    }
    
}