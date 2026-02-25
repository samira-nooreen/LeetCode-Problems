import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        int n = arr.length;
        int prefixSum = 0;
        int maxLen = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            
            // Transform into +1 / -1
            if (arr[i] > k)
                prefixSum += 1;
            else
                prefixSum -= 1;
            
            // If prefixSum > 0, whole array till i is valid
            if (prefixSum > 0)
                maxLen = i + 1;
            
            // Store first occurrence of prefixSum
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
            
            // Check if there exists prefixSum - 1
            if (map.containsKey(prefixSum - 1)) {
                int len = i - map.get(prefixSum - 1);
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}
