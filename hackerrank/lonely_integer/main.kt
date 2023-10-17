fun main(args: Array<String>) {
    val n = readln().toInt()

    val input = readln().split(' ').filter(String::isNotBlank).map { s -> s.toInt() }

    val seen = HashSet<Int>()
    input.forEach {
        if (seen.contains(it)) seen.remove(it)
        else seen.add(it)
    }

    println(seen.first())
}
