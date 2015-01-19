public class Solution {
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3) {
            return rst;
        }
        Arrays.sort(num);
        
        // for loop sandwitching
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue; // to skip duplicates
            }
            
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum == 0) {
                    // store current solution
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[left]);
                    tmp.add(num[right]);
                    rst.add(tmp);
                    // move cursor to prevent identical solution
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) { // to skip duplicates
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) { // to skip duplicates
                        right--;
                    }
                }
                
                //sandwiching
                else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return rst;
    }
}