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
    val n = readln().toInt()

    val input = readln().split(' ').filter(String::isNotBlank).map { s -> s.toInt() }

    val seen = HashSet<Int>()
    input.forEach {
        if (seen.contains(it)) seen.remove(it)
        else seen.add(it)
    }

    println(seen.first())
}
