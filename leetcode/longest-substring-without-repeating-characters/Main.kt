import java.util.*

class Solution {
    var longestIndex = 0
    var longestLen = 0
    var currentIndex = 0
    var index = 0
    var seen = BitSet(256)

    fun terminate() {
        var currentLen = index - currentIndex
        if (currentLen > longestLen) {
            longestLen = currentLen
            longestIndex = currentIndex
        }
    }

    fun lengthOfLongestSubstring(s: String): Int {
        while (currentIndex < s.length) {
            if (index >= s.length) {
                terminate()
                seen.clear()
                currentIndex++
                index = currentIndex
                continue
            }
            val ch = s[index]
            if (seen[ch.code]) {
                terminate()
                seen.clear()
                currentIndex++
                index = currentIndex
            }

            seen[ch.code] = true
            index++
        }

        terminate()

        return longestLen
    }
}

fun main(args: Array<String>) {

}
