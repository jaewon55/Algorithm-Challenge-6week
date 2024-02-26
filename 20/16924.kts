// https://www.acmicpc.net/problem/16924

import java.util.*

val DOT = '.'
val STAR = '*'

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(n) {
	val line = reader.readLine()
	CharArray(m) { line[it] } 
}
val visit = Array(n) { BooleanArray(m) }
val printList = mutableListOf<String>()
var k = 0

fun solve(centerX: Int, centerY: Int) {
	var size = 0
	var up = centerX
	var down = centerX
	var left = centerY
	var right = centerY

	while (true) {
		up += 1
		down -= 1
		left -= 1
		right += 1

		if (n <= up || down < 0 || m <= right || left < 0) break
		if (map[up][centerY] != STAR || map[down][centerY] != STAR || map[centerX][left] != STAR || map[centerX][right] != STAR) break

		++size

		visit[up][centerY] = true
		visit[down][centerY] = true
		visit[centerX][left] = true
		visit[centerX][right] = true
	}

	if (0 < size) {
		visit[centerX][centerY] = true
		++k
		printList.add("${centerX + 1} ${centerY + 1} ${size}")
	}
}

fun main() {
	for (x in 1 until n ) {
		for (y in 1 until m) {
			if (map[x][y] == STAR) solve(x, y)
		}
	}

	for (x in 0 until n ) {
		for (y in 0 until m) {
			if (map[x][y] == STAR && !visit[x][y]) {
				k = -1
				break
			}
		}
		if (k == -1) break
	}
	writer.write("$k\n")
	if (k != -1) {
		for (str in printList) {
			writer.write("$str\n")
		}
	}
	writer.flush()
}

main()
