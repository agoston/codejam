import java.io.*
import java.lang.IllegalArgumentException
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun main(args: Array<String>) {
    val (x1In, v1In, x2In, v2In) = readLine()!!.split(' ').filter(String::isNotBlank).map { s -> s.toInt() }

    // v1 > v2
    val (x1, v1, x2, v2) = if (v1In > v2In) arrayOf(x1In, v1In, x2In, v2In)
    else arrayOf(x2In, v2In, x1In, v1In)

    println(solve(v1, v2, x1, x2))
}

private fun solve(v1: Int, v2: Int, x1: Int, x2: Int): String {
    if (x1 > x2) return "NO"

    var p1 = x1
    var p2 = x2

    while (p1 <= p2) {
        if (p1 == p2) return "YES"
        p1 += v1
        p2 += v2
    }
    return "NO"
}
