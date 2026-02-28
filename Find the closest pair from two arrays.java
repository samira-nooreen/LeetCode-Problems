class Solution {
    public ArrayList<Integer> findClosestPair(int[] arr1, int[] arr2, int x) {
        int i = arr1.length - 1;
        int j = 0;
        
        int minDiff = Integer.MAX_VALUE;
        int resA = -1, resB = -1;
        
        while (i >= 0 && j < arr2.length) {
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);
            
            if (diff < minDiff) {
                minDiff = diff;
                resA = arr1[i];
                resB = arr2[j];
            }
            
            if (sum < x) {
                j++;
            } else if (sum > x) {
                i--;
            } else {
                break;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(resA);
        result.add(resB);
        return result;
    }
}
