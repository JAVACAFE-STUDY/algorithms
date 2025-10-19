class Solution {
    // 전체 시간복잡도: O(n) + O(1) = O(n)
    // 전체 공간복잡도: O(n)

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val answer = IntArray(n)
        val stack = ArrayDeque<Int>()

        // 시간복잡도: O(n)
        for (i in 0 until n) {
            // 시간복잡도: O(1)
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val idx = stack.removeLast()
                answer[idx] = i - idx
            }
            stack.addLast(i)
        }

        return answer
    }
}