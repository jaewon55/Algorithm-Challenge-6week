// https://www.acmicpc.net/problem/2178

import java.util.*

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(n) {
	val line = reader.readLine()
	BooleanArray(m) { line[it] == '1' }
}
val visit = Array(n) {
	BooleanArray(m)
}
val distance = Array(n) {
	IntArray(m)
}
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun bfs() {
	val queue = ArrayList<Pair<Int, Int>>()

	queue.add(0 to 0)
	visit[0][0] = true
	while (!queue.isEmpty()) {
		val p = queue.removeAt(0)
		val y = p.first
		val x = p.second

		for (i in 0 until 4) {
			val nextX = x + dx[i]
			val nextY = y + dy[i]
			if (nextX < 0 || m <= nextX || nextY < 0 || n <= nextY) continue
			if (!map[nextY][nextX] || visit[nextY][nextX]) continue
			distance[nextY][nextX] = distance[y][x] + 1
			visit[nextY][nextX] = true
			queue.add(nextY to nextX)
		}
	}
}

fun main() {
	bfs()
	println(distance[n - 1][m - 1] + 1)
}

main()
