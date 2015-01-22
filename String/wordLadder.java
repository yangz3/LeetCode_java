public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict == null || dict.size() == 0){
            return 0;
        }
        
        int counter = 1;
        Queue<String> queue = new LinkedList<String>();
        
        queue.offer(start);
        dict.remove(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                // rather than iterate the set we iterate the alphabet
                for(int j = 0; j < start.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        
                        String temp = replace(current, j, c);
                        if(temp.equals(end)){ // .equals rather than "=="
                            return counter + 1;
                        }
                        if(dict.contains(temp)){
                            queue.offer(temp);
                            dict.remove(temp); // simpler than using a hashset to mark the nodes traversed
                        }
                    }
                    
                }
            }
            counter++;
            
        }
        return -0;
        
    }
    
    private String replace(String s, int i, char c){
        char[] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}