fun readInt() = readln().toInt()

fun main() {
	val a = readInt()
	val b = readln()
	for (i in b.length - 1 downTo 0) {
		println(a * (b[i] - '0'))
	}
	println(a * b.toInt())
}

main()