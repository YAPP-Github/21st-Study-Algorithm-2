package leetcode

import java.util.*

/*
* Jump Game - Medium
* https://leetcode.com/problems/jump-game/description/
* Greedy, DP
*/

class Solution {
    enum class IndexState {
        UNINITIALIZED, SUCCESS, FAIL
    }

    fun canJump(nums: IntArray): Boolean {
        val dp = Array(nums.size) { IndexState.UNINITIALIZED }
        return greedy(nums, dp, 0)
    }

    fun greedy(nums: IntArray, dp: Array<IndexState>, index: Int): Boolean {

        if (index == nums.lastIndex) return true

        if (nums[index] == 0) {
            dp[index] = IndexState.FAIL
            return false
        }

        if (dp[index] == IndexState.FAIL) return false

        for(i in 1..nums[index]) {
            val nextIndex = index + i
            if(greedy(nums, dp, nextIndex)) {
                dp[index] = IndexState.SUCCESS
                return true
            }
        }

        dp[index] = IndexState.FAIL
        return false
    }

    // Memory Limit Exceed
    fun BFS(nums: IntArray): Boolean {
        val queue = LinkedList<Int>()
        val visited = HashSet<Int>()

        queue.add(0)

        while (queue.isNotEmpty()) {
            val curr = queue.poll()

            if (curr == nums.lastIndex) return true
            if (!visited.add(curr)) continue

            for (i in 1..nums[curr]) {
                val next = curr + i
                if (next > nums.lastIndex) continue
                queue.add(next)
            }
        }

        return false
    }
}
