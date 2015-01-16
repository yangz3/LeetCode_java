public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // use HashMap to save the number of each string in the list
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        // Another HashMap is used to save the number of strings we found.
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
                int k = i + j * n;
                String stub = S.substring(k, k + n);
                
                if(!found.containsKey(stub)){
                    found.put(stub, 1);
                }
                else{
                    found.put(stub, found.get(stub) + 1);
                }
                
            }
            if (found.equals(toFind)) result.add(i);
        }
        return result;
    }
}