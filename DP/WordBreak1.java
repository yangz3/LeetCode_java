public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        boolean[] states = new boolean[s.length() + 1];
        Arrays.fill(states, false);
        states[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j <= i; j++){
                String tmp = s.substring(j, i);
                if(states[j] == true && dict.contains(tmp)){
                    states[i] = true;
                    break;
                }
            }
        }
        return states[s.length()];
    }
    
    
}