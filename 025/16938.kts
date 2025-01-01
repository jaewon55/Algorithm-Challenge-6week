// https://www.acmicpc.net/problem/16938

val N = 0
val L = 1
val R = 2
val X = 3

fun main() {
	val reader = System.`in`.bufferedReader()
	val input = reader.readLine().split(" ").map{ it.toInt() }
	val difficulty = reader.readLine().split(" ").map { it.toInt() }
	var result = 0

	fun isPossible(problems: List<Int>): Boolean {
		if (problems.size < 2) return false
		if (problems.sum() < input[L] || input[R] < problems.sum()) return false
		if (problems.max() - problems.min() < input[X]) return false
		return true
	}

	fun recurv(depth: Int, start: Int, problems: MutableList<Int>) {
		if (depth == input[N]) return

		for (i in start until input[N]) {
			problems.add(difficulty[i])
			if (isPossible(problems)) ++result
			recurv(depth + 1, i + 1, problems)
			problems.removeAt(problems.size - 1)
		}
	}

	recurv(0, 0, mutableListOf<Int>())
	println(result)
}

main()
