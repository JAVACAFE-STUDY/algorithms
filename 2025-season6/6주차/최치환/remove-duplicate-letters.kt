class Solution {
    // 시간복잡도: O(n) + O(n) + O(1) = O(n)
    // 공간복잡도: O(k) (최대 26)

    fun removeDuplicateLetters(s: String): String {

        val lastIndex = IntArray(26)
        val seen = BooleanArray(26)
        val stack = ArrayDeque<Char>()

        // 시간복잡도: O(n)
        for (i in s.indices) {
            lastIndex[s[i] - 'a'] = i
        }

        // 시간복잡도: O(n)
        for (i in s.indices) {
            val c = s[i]
            if (seen[c - 'a']) {
                continue
            }

            // 시간복잡도: O(1)
            while (stack.isNotEmpty() && c < stack.last() && i < lastIndex[stack.last() - 'a']) {
                val removed = stack.removeLast()
                seen[removed - 'a'] = false
            }

            stack.addLast(c)
            seen[c - 'a'] = true
        }

        return stack.joinToString("")
    }
}