public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        Arrays.sort(num);
        // first sort num and in the recursion use continue to prevent duplicated result
        // this is a quite common skill to select non-duplicated result from duplicated array
        helper(tmp, rst, num, target, 0);
        return rst;
    }
    private void helper(ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rst, int[] num, int target, int pos){
        if(tmp.size() == 4){
            int sum = 0;
            for(int i:tmp){
                sum += i;
            }
            if(sum == target){
                rst.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        
        for(int i = pos; i < num.length; i++){
            
            if(i != pos && num[i] == num[i - 1]){
                continue;
            }
            
            tmp.add(num[i]);
            helper(tmp, rst, num, target, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    
    // another solution: same technique with 3sum
    // Time complexity O(N3)
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;
                
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        rst.add(tmp);
                        left++;
                        right--;
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        
        return rst;
    }
    
    
    // hashtable O(N2) time complexity
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        //Create the dictionary of sum and list of pairs of indexes
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<ArrayList<Integer>>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }
        //Use HashSet to prevent duplicate result.
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sumA : dict.keySet()) {
            if (dict.containsKey(target - sumA)) {
                
                ArrayList<ArrayList<Integer>> pairsA = dict.get(sumA);
                ArrayList<ArrayList<Integer>> pairsB = dict.get(target - sumA);
                
                
                for (ArrayList<Integer> pair1 : pairsA) {
                    for (ArrayList<Integer> pair2 : pairsB) {
                        
                        //Make sure there is no same element in two pairs.
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
                        
                        ArrayList<Integer> tmpResult = new ArrayList<>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        //Sort the list and add it into the set.
                        Collections.sort(tmpResult);
                        set.add(tmpResult);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.addAll(set); // from hashset to arraylist 
        return ret;
    }
}