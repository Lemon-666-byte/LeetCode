class Solution {

    /**
     * 26. 删除有序数组中的重复项
     * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     * <p>
     * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
     * <p>
     * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
     * 返回 k 。
     * 判题标准:
     * <p>
     * 系统会用下面的代码来测试你的题解:
     * <p>
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     * <p>
     * int k = removeDuplicates(nums); // 调用
     * <p>
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     * 如果所有断言都通过，那么您的题解将被 通过。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按 非严格递增 排列
     * <p>
     * <p>
     * --------------------------------------------------------
     * <p>
     * 这道题目的要求是：对给定的有序数组 nums 删除重复元素，在删除重复元素之后，每个元素只出现一次，并返回新的长度，上述操作必须通过原地修改数组的方法，使用 O(1) 的空间复杂度完成。
     * <p>
     * 由于给定的数组 nums 是有序的，因此对于任意 i<j，如果 nums[i]=nums[j]，则对任意 i≤k≤j，必有 nums[i]=nums[k]=nums[j]，即相等的元素在数组中的下标一定是连续的。利用数组有序的特点，可以通过双指针的方法删除重复元素。
     * <p>
     * 如果数组 nums 的长度为 0，则数组不包含任何元素，因此返回 0。
     * <p>
     * 当数组 nums 的长度大于 0 时，数组中至少包含一个元素，在删除重复元素之后也至少剩下一个元素，因此 nums[0] 保持原状即可，从下标 1 开始删除重复元素。
     * <p>
     * 定义两个指针 fast 和 slow 分别为快指针和慢指针，快指针表示遍历数组到达的下标位置，慢指针表示下一个不同元素要填入的下标位置，初始时两个指针都指向下标 1。
     * <p>
     * 假设数组 nums 的长度为 n。将快指针 fast 依次遍历从 1 到 n−1 的每个位置，对于每个位置，如果 nums[fast]
     * 
     * =nums[fast−1]，说明 nums[fast] 和之前的元素都不同，因此将 nums[fast] 的值复制到 nums[slow]，然后将 slow 的值加 1，即指向下一个位置。
     * <p>
     * 遍历结束之后，从 nums[0] 到 nums[slow−1] 的每个元素都不相同且包含原数组中的每个不同的元素，因此新的长度即为 slow，返回 slow 即可。
     * <p>
     * 作者：力扣官方题解
     * 链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/728105/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    /**
     * 27. 移除元素
     * 简单
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
     * <p>
     * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
     * <p>
     * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
     * 返回 k。
     * 用户评测：
     * <p>
     * 评测机将使用以下代码测试您的解决方案：
     * <p>
     * int[] nums = [...]; // 输入数组
     * int val = ...; // 要移除的值
     * int[] expectedNums = [...]; // 长度正确的预期答案。
     * // 它以不等于 val 的值排序。
     * <p>
     * int k = removeElement(nums, val); // 调用你的实现
     * <p>
     * assert k == expectedNums.length;
     * sort(nums, 0, k); // 排序 nums 的前 k 个元素
     * for (int i = 0; i < actualLength; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     * 如果所有的断言都通过，你的解决方案将会 通过。
     * ------------------------------------------------------------------------------------------------------------------
     * 方法一：双指针
     * 思路及算法
     * <p>
     * 由于题目要求删除数组中等于 val 的元素，因此输出数组的长度一定小于等于输入数组的长度，我们可以把输出的数组直接写在输入数组上。可以使用双指针：右指针 right 指向当前将要处理的元素，左指针 left 指向下一个将要赋值的位置。
     * <p>
     * 如果右指针指向的元素不等于 val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
     * <p>
     * 如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位。
     * <p>
     * 整个过程保持不变的性质是：区间 [0,left) 中的元素都不等于 val。当左右指针遍历完输入数组以后，left 的值就是输出数组的长度。
     * <p>
     * 这样的算法在最坏情况下（输入数组中没有元素等于 val），左右指针各遍历了数组一次。
     * <p>
     * 作者：力扣官方题解
     * 链接：<a href="https://leetcode.cn/problems/remove-element/solutions/730203/yi-chu-yuan-su-by-leetcode-solution-svxi/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}