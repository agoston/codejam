fun main(args: Array<String>) {
    val n = readln().toInt()
    val surface = List(n) { readln().split(' ').map { it.toInt() }.let { Point(it[0], it[1]) } }

    val flatSurface = filterHorizontal(surface)

    // game loop
    while (true) {
        val (X, Y, hSpeed, vSpeed, fuel, rotate, power) = readln().split(' ').map { it.toInt() }
//        val hSpeed = input.nextInt() // the horizontal speed (in m/s), can be negative.
//        val vSpeed = input.nextInt() // the vertical speed (in m/s), can be negative.
//        val fuel = input.nextInt() // the quantity of remaining fuel in liters.
//        val rotate = input.nextInt() // the rotation angle in degrees (-90 to 90).
//        val power = input.nextInt() // the thrust power (0 to 4).


    }
}

// returns points that have horizontal surface on either side
fun filterHorizontal(surface: List<Point>): List<Point> {
    var result = mutableListOf<Point>()
    val it = surface.iterator()
    var prev = it.next()
    for (point in it) {
        if (prev.y == point.y) {
            if (result.lastOrNull() !== prev) result.add(prev)
            result.add(point)
        }
        prev = point
    }
    return result
}

operator fun <T> List<T>.component6(): T = get(5)
operator fun <T> List<T>.component7(): T = get(6)

data class Point(
    val x: Int,
    val y: Int
)