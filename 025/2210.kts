// https://www.acmicpc.net/problem/2210

fun main() {
	val reader = System.`in`.bufferedReader()
	val map = Array(5) { reader.readLine().split(" ").map{ it.toInt() } }
	val numbers = mutableListOf<Int>()
	val dx = arrayOf(1, -1, 0, 0)
	val dy = arrayOf(0, 0, 1, -1)

	fun dfs(depth: Int, x: Int, y: Int, number: Int) {
		if (depth == 5) {
			if (number !in numbers) numbers.add(number)
			return
		}

		for (i in 0 until 4) {
			val nx = x + dx[i]
			val ny = y + dy[i]

			if (nx in 0 until 5 && ny in 0 until 5) {
				dfs(depth + 1, nx, ny, number * 10 + map[nx][ny])
			}
		}
	}

	for (x in 0 until 5) {
		for (y in 0 until 5) {
			dfs(0, x, y, map[x][y])
		}
	}

	println(numbers.size)
}

main()
