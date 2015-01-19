public class Solution {
    public List<String> anagrams(String[] strs) {
        
        // another solution: sort the string so that anagrams will have same return value
        // hashmap to store letter count String and all strings with that letter count
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        
        for(String str : strs){
            String letterCount = count(str);
            if(map.containsKey(letterCount)){
                map.get(letterCount).add(str);
            }else{
                map.put(letterCount, new ArrayList<String>());
                map.get(letterCount).add(str);
            }
        }
        
        for(ArrayList<String> tmp : map.values()){
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }
        
        return result;
    }
    
    // for example "aab" will return 21000..0 as result
    private String count(String str){
        int[] a = new int[26];
        Arrays.fill(a, 0);
        for(int i = 0; i < str.length(); i++){
            a[str.charAt(i) -'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for(int i : a){
            builder.append(Integer.toString(i));
        }
        return builder.toString();
    }
}