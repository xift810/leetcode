class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length ==0){
            return -1;
        }
        
        int start = 0;
        // 很容易计算成长度，坐标的话肯定要检查一遍
        int end = nums.length-1;
        
        while (start <= end){
            int mid = start + (end-start)/2;
            if (target == nums[mid]) {
                return mid;
            }
            // 这里很容易漏写=号，会发生比较难以察觉的错误 （[3,1] ，1 ）
            // 从逻辑来说是如果前半段是有序的，那么对于前半段进行比较。
            // 前半段如果是1个数字，应该也算是有序的。不能让它进入后半段去寻找
            // 对于前面的列子，让它认为[3]是一个有序数列，并且1 不在里面，所以去后半段寻找是正确的思路
            // 如果不写，就变成[3] 不是一个有序数列，[1]是有序数列
            if (nums[start] <= nums[mid]){
                if (target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                } else {
                    start = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                    
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}