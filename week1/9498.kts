fun readInt() = readln().toInt()

fun main() {
	val score = readInt()
	val ret = when(score) {
		in 90..100 -> "A"
		in 80..89 -> "B"
		in 70..79 -> "C"
		in 60..69 -> "D"
		else -> "F"
	}
	println(ret)
}

main()