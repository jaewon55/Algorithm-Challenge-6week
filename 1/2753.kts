fun readInt() = readln().toInt()
fun isLeap(y: Int) = (y % 4 == 0 && y % 100 != 0 ) || y % 400 == 0

fun main() {
	val year = readInt()
	val ret = if (isLeap(year)) 1 else 0
	println(ret)
}

main()
