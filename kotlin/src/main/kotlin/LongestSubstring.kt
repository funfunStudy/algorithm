
import kotlin.system.measureTimeMillis
/*Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/
class Solution2 {
    fun lengthOfLongestSubstring(s: String): Int = if (s.length <= 1) s.length else recursive(s).length
    private tailrec fun recursive(
        s: String,
        acc: String = ""
    ): String = when {
        s.isEmpty() -> acc
        else -> {
            val tail = s.drop(1)
            val recursiveAcc = recursive2(s)
            val greaterThan = acc.length > recursiveAcc.length
            val result = if (greaterThan) acc else recursiveAcc
            recursive(
                tail,
                result
            )
        }
    }
    private tailrec fun recursive2(
        s: String,
        acc: String = ""
    ): String = when {
        s.isEmpty() -> acc
        else -> {
            val head = s[0]
            val tail = s.drop(1)
            when {
                acc.contains(head) -> acc
                else -> recursive2(tail, acc + head)
            }
        }
    }
}
