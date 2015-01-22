public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for(int i = 0; i < s.length(); i++){
            if(map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){ // always check before pop
                    return false;
                }
                char c = stack.pop();
                if(c != map.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}