package leetcode

import kotlin.math.max

/*
* Longest Substring Without Repeating Characters - Medium
* https://leetcode.com/problems/longest-substring-without-repeating-characters/
* Hash Table
*/

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<String>()
        var max = 0

        for (i in s.indices) {
            var curr = "" + s[i]
            for (j in i + 1 until s.length) {
                if (curr.contains(s[j])) {
                    break
                }

                curr += s[j]
            }

            hashSet.add(curr)
        }

        println(hashSet)

        hashSet.forEach {
            max = max(it.length, max)
        }

        return max
    }
}

