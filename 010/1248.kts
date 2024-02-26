// https://www.acmicpc.net/problem/1248

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val chars = reader.readLine()
val matrix = Array(n) {
	CharArray(n)
}
val sequence = IntArray(n)

fun valid(depth: Int): Boolean {
	var sum = 0
	for (i in depth downTo 0) {
		sum += sequence[i]
		when(matrix[i][depth]) {
			'-' -> if (0 <= sum) return false
			'+' -> if (sum <= 0) return false
			else -> if (sum != 0) return false
		}
	}
	return true
}

fun recur(depth: Int) {
	var idx = 0
	for (i in 0 until n) {
		for (j in i until n) {
			matrix[i][j] = chars[idx++]
		}
	}
	if (depth == n) {
		println(sequence.joinToString(" "))
		kotlin.system.exitProcess(0)
	}

	for (i in -10..10) {
		sequence[depth] = i
		if (!valid(depth)) continue
		recur(depth + 1)
	}
}

fun main() {
	recur(0)
}

main()
