// https://www.acmicpc.net/problem/16637

fun cal(l: Int, r: Int, oper: Char): Int = when(oper) {
	'+' -> l + r
	'-' -> l - r
	'*' -> l * r
	else -> 0
}


fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val exp = reader.readLine()
	var result = Int.MIN_VALUE

	fun recurv(depth: Int, sum: Int) {
		if (n <= depth) {
			result = maxOf(sum, result)
			return
		}

		val oper = if (depth == 0) '+' else exp[depth - 1]

		if (depth + 2 < n) {
			val bracket = cal(exp[depth].toInt() - '0'.toInt(), exp[depth + 2].toInt() - '0'.toInt(), exp[depth + 1])
			recurv(depth + 4, cal(sum, bracket, oper))
		}
		recurv(depth + 2, cal(sum, exp[depth].toInt() - '0'.toInt(), oper))
	}

	recurv(0, 0)
	println(result)
}

main()
