fun main(args: Array<String>) {
    val T = readLine()!!.toInt()
    for (t in 1..T) {
        val n = readLine()!!.toInt()
        val z = readLine()!!.splitToSequence(' ').map { it.toInt() }.toMutableList()

        println(solve3for(z).joinToString(separator = " "))
    }
}

fun solve3for(x: List<Int>): Array<Int> {
    val res = Array<Int>(x.size) { -1 }

    for (i in x.indices) {
        if (res[i] > 0) continue

        var count = 0
        val cycle = mutableListOf<Int>()
        var p = i
        do {
            cycle.add(p)
            count++
            p = x[p] - 1
        } while (p != i)

        cycle.forEach {res[it] = count}
    }

    return res
}
