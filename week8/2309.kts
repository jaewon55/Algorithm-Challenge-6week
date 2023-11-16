// https://www.acmicpc.net/problem/2309

fun main() {
	val reader = System.`in`.bufferedReader()
	val heights = Array(9) {
		reader.readLine().toInt()
	}
	val result = Array(7) { 0 }
	var solved = false

	fun solve(depth: Int, index: Int, sum: Int) {
		if (depth == 7 && sum == 100) {
			solved = true
			result.sort()
			for (num in result) {
				println(num)
			}
			return
		}
		if (depth == 7) return

		for (i in index until 9) {
			if (sum + heights[i] <= 100) {
				result[depth] = heights[i]
				solve(depth + 1, i + 1, sum + heights[i])
				if (solved) return
			}
		}
	}

	solve(0, 0, 0)
}

main()
