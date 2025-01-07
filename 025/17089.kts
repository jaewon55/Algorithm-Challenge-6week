// https://www.acmicpc.net/problem/17089

fun main() {
	val reader = System.`in`.bufferedReader()
	val (n, m) = reader.readLine().split(" ").map{ it.toInt() }
	val friendCount = Array(n + 1) { 0 }
	val relations = Array(n + 1) { BooleanArray(n + 1) }
	var result = -1

	for (i in 0 until m) {
		val (x, y) = reader.readLine().split(" ").map{ it.toInt() }
		friendCount[x] += 1
		friendCount[y] += 1
		relations[x][y] = true
		relations[y][x] = true
	}

	for (a in 0 .. n) {
		for (b in a + 1 .. n) {
			if (!relations[a][b]) continue
			for (c in b + 1 .. n) {
				if (!relations[a][c] || !relations[b][c]) continue
				val sum = friendCount[a] + friendCount[b] + friendCount[c] - 6
				result = if (result < 0) sum else minOf(sum, result)
			}
		}
	}

	/*fun recurv(depth: Int, start: Int, select: MutableList<Int>) {
		if (depth == 3) {
			val a = select[0]
			val b = select[1]
			val c = select[2]
			if (!relations[a][c]) return
			val sum = friendCount[a] + friendCount[b] + friendCount[c] - 6
			result = if (result < 0) sum else minOf(sum, result)
			return
		}

		for (p in start .. n) {
			if (select.isNotEmpty() && !relations[select.last()][p]) continue
			select.add(p)
			recurv(depth + 1, start + 1, select)
			select.removeLast()
		}
	}*/

	// recurv(0, 0, mutableListOf())
	println(result)
}

main()
