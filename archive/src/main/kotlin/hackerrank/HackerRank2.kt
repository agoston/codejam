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
    val moves = readLine()!!

    val res = moves.fold(Pair(0,0)) { coord, dir ->
        when (dir) {
            'N' -> Pair(coord.first + 1, coord.second)
            'S' -> Pair(coord.first - 1, coord.second)
            'E' -> Pair(coord.first, coord.second + 1)
            'W' -> Pair(coord.first, coord.second - 1)
            else -> throw IllegalArgumentException("Unknown direction '$dir'")
        }
    }

    if (res == Pair(0,0)) println("True")
    else println("False")
}
