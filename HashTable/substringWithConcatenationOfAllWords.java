public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int m = L.length, n = L[0].length();
        
        // put the word and the number of it appear in the L
        for (int i = 0; i < m; i ++){
            if (!toFind.containsKey(L[i])){
                toFind.put(L[i], 1);
            }
            else{
                toFind.put(L[i], toFind.get(L[i]) + 1);
            }
        }
        
        // m is the length of L and n is the length of the word in L
        // iterate throught the string S
        for (int i = 0; i <= S.length() - n * m; i++){
            found.clear();
            
            // parse the substring starting from i in chunck of length n
            for (int j = 0; j < m; j++){
                int start = i + j * n;
                String candidate = S.substring(start, start + n);
                
                if(!toFind.containsKey(candidate)){ // trim
                    break;
                }
                
                if(!found.containsKey(candidate)){
                    found.put(candidate, 1);
                }
                else{
                    found.put(candidate, found.get(candidate) + 1);
                }
                
            }
            if (found.equals(toFind)) {
                result.add(i);
            }
        }
        return result;
    }
}