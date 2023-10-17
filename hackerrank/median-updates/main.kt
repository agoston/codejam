import java.text.DecimalFormat

fun main(args: Array<String>) {
    val n = readln().trim().toInt()
    var sortedList = mutableListOf<Int>();
    val df = DecimalFormat("###################.#")

    for (i in 1..n) {
        runCatching {
            val input = readln().trim().split(' ')
            require(input.size == 2)

            val value = input[1].toInt()
            when (input[0].lowercase()) {
                "a" -> sortedList.insertSorted(value)
                "r" -> sortedList.removeSorted(value)
                else -> throw IllegalArgumentException()
            }

            println(df.format(sortedList.medianValue()))

        }.onFailure {
            println("Wrong!")
        }
    }
}

fun MutableList<Int>.medianValue(): Double {
    require(isNotEmpty())

    val half = size shr 1
    return if (size and 1 == 0) {
        (this[half].toDouble() + this[half - 1].toDouble()) / 2
    } else {
        this[half].toDouble()
    }
}

fun <T : Comparable<*>> MutableList<T>.insertSorted(value: T) {
    val searchPosition = binarySearch { compareValues(it, value) }
    val insertPosition = if (searchPosition < 0) -searchPosition - 1 else searchPosition
    add(insertPosition, value)
}

/**
 * @throws ElementNotFoundException
 */
fun <T : Comparable<*>> MutableList<T>.removeSorted(value: T) {
    val position = binarySearch { compareValues(it, value) }

    if (position < 0) {
        throw ElementNotFoundException()
    } else {
        removeAt(position)
    }
}

class ElementNotFoundException : RuntimeException("", null, true, false)
