package TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        if (nums == null || nums.length <=1){
        	//用throw 要比直接返回null好
        	throw new IllegalArgumentException("No two sum solution");
        }
        // HashMap之后可以只有方括号
        Map<Integer, Integer> record = new HashMap<>();
        //需要小标的时候不能使用 for in
//        for (int i:nums) {
//           // record.add(nums[i] , i);
//            record.put(nums[i] , i);
//        }
            
        for (int i = 0 ;i<nums.length;i++){
        	record.put(nums[i], i);
        }
        
        for (int i=0 ; i < nums.length;i++) {
            int j = target - nums[i];
            if (record.containsKey(j) && record.get(j)!=i ){
            //1 Map只有两个方法，containsKey containsValue
            //2 考虑到下标相同的元素*2 == target
//            if (record.containsKey(j)){
            //if (record.contains(j)){
                return new int[]{i, record.get(j)};
            }
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}