// https://www.acmicpc.net/problem/16945

fun main() {
	val reader = System.`in`.bufferedReader()
	val input = Array(3) {
		val line = reader.readLine().split(" ")
		IntArray(3) { line[it].toInt() }
	}
	val map = Array(3) { IntArray(3) }
	val visit = BooleanArray(10)
	var result = Int.MAX_VALUE

	fun isMagicSquare(): Boolean {
		if (map[0][0] + map[1][1] + map[2][2] != 15) return false
		if (map[0][2] + map[1][1] + map[2][0] != 15) return false
		for (i in 0 until 3) {
			if (map[i].sum() != 15) return false
			if (map[0][i] + map[1][i] + map[2][i] != 15) return false
		}
		return true
	}

	fun recurv(depth: Int) {
		if (depth == 9) {
			if (!isMagicSquare()) return
			var sum = 0
			for (x in 0 until 3) {
				for (y in 0 until 3) {
					sum += Math.abs(input[x][y] - map[x][y])
				}
			}
			result = minOf(result, sum)
			return
		}

		for (i in 1 .. 9) {
			if (visit[i]) continue
			map[depth / 3][depth % 3] = i
			visit[i] = true
			recurv(depth + 1)
			visit[i] = false
		}
	}

	recurv(0)
	println(result)
}

main()
