class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int closestsum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currsum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(currsum - target);
                if(diff < minDiff){
                    minDiff = diff;
                    closestsum = currsum;
                }
                if(currsum < target){
                    left++;
                   } else if(currsum > target){
                        right--;
                    }else{
                        return currsum;
                    }
                }
            }
            return closestsum;
    }
}