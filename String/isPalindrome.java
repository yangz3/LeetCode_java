public class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                stack.push(Character.toLowerCase(s.charAt(i)));
            }
            if(Character.isDigit(s.charAt(i))){
                stack.push(s.charAt(i));
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                if(stack.pop() != Character.toLowerCase(s.charAt(i))){
                    return false;
                }
            }
            if(Character.isDigit(s.charAt(i))){
                if(stack.pop() != s.charAt(i)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
}


// another solution maintain left and right pointers
/**
 * Copyright: NineChapter
 * - Algorithm Course, Mock Interview, Interview Questions
 * - More details on: http://www.ninechapter.com/
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }
            
            if (front == s.length()) { // for emtpy string “.,,,”
                return true;
            }
            
            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }
            
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }
        
        return end <= front;
    }
    
    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}