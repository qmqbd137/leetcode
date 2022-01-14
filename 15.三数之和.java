import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (33.63%)
 * Likes:    3842
 * Dislikes: 0
 * Total Accepted:    666.2K
 * Total Submissions: 2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
 * 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^5 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2)
            return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0)
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1,
                    // right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else { 
                    // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
    // public List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> allResSet = new ArrayList<>();
    // if(nums.length < 3 ){
    // return allResSet;
    // }
    // Arrays.sort(nums);
    // int star = 0;
    // int end = nums.length - 1;
    // int minSum = nums[star] + nums[star+1] +nums[star+2];
    // int maxSum = nums[end] + nums[end-1] +nums[end-2];
    // if(minSum>0 || maxSum < 0){
    // return allResSet;
    // }
    // //可以使用双指针，第二，第三层循环可以使用双指针的方法
    // for (int i = 0; i < nums.length; i++) {
    // int a = nums[i];
    // int left = i+1;
    // int right = nums.length-1;
    // while(left<right){
    // int b = nums[left];
    // int c = nums[right];
    // List<Integer> oneResSet = new ArrayList<>();
    // if(a+b+c == 0){
    // oneResSet.add(a);
    // oneResSet.add(b);
    // oneResSet.add(c);
    // if(!allResSet.contains(oneResSet)){
    // allResSet.add(oneResSet);
    // }
    // }
    // left++;
    // right--;
    // }
    // }
    // return allResSet;
    // }
}
// @lc code=end
