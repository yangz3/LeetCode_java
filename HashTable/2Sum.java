public class Solution {
    // solution1
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = {-1,-1};
        HashMap<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(!valueToIndex.containsKey(numbers[i])){
                valueToIndex.put(numbers[i], i);
            }
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(valueToIndex.containsKey(target - numbers[i])){
                int index1 = i+1;
                int index2 = valueToIndex.get(target - numbers[i]) + 1;
                if(index1 == index2){
                    continue;
                }
                ret[0] = Math.min(index1, index2);
                ret[1] = Math.max(index1, index2);
            }
        }
        return ret;
    }
    
    // solution2 sandwiching
    
    
}