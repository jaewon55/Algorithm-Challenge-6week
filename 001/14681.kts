fun readInt() = readln().toInt()

fun main() {
	val x = readInt()
	val y = readInt()
	val ret = if (x > 0) {
		if (y > 0) 1 else 4
	} else {
		if (y > 0) 2 else 3
	}
	println(ret)
}

main()