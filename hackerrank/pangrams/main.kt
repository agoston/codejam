import kotlin.collections.*
import kotlin.io.*

fun main(args: Array<String>) {
    val pangram = readLine()!!

    val seen = HashSet<Char>(('a'..'z').toList())

    pangram.forEach { seen.remove(it.toLowerCase()) }

    if (seen.isNotEmpty()) print("not ")
    print("pangram")
}

