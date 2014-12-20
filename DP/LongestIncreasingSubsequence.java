class Solution {
public:
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    
    /*
     Given a sequence of integers, find the longest increasing subsequence (LIS). You code should return the length of the LIS. Example For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3 For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
     */
    
    int longestIncreasingSubsequence(int[] nums) {
        int f[nums.length];
        Arrays.fill(f,1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            
            max = Math.max(max, f[i]);
        }
        return max;
    }
};