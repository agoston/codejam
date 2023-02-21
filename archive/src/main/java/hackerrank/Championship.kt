import java.util.*

fun main(args: Array<String>) {
    val T = readLine()!!.toInt()
    for (t in 1..T) {
        val (n, m) = readLine()!!.splitToSequence(' ').map { it.toInt() }.toList()
        val x = BitSet(n * m)
        for (line in 0..n - 1) {
            readLine()!!.splitToSequence(' ').forEachIndexed { i, it -> if (it == "1") x.set(line * m + i) }
        }

        println(solvefor(x, n, m))
    }
}

fun solvefor(a: BitSet, n: Int, m: Int): Long {
    var res: Long = 0
    for (y in 0 until n) {
        for (x in 0 until m) {
            if (a[pos(x, y, m)]) continue

            // left
            if (x > 0) for (j in x - 1 downTo 0) if (a[pos(j, y, m)]) {
                res++; break;
            }
            // top
            if (y > 0) for (j in y - 1 downTo 0) if (a[pos(x, j, m)]) {
                res++; break;
            }
            // right
            if (x < m - 1) for (j in x + 1 until m) if (a[pos(j, y, m)]) {
                res++; break;
            }
            // bottom
            if (y < n - 1) for (j in y + 1 until n) if (a[pos(x, j, m)]) {
                res++; break;
            }
        }
    }
    return res
}

fun pos(x: Int, y: Int, col: Int) = y * col + x