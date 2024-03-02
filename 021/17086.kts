// https://www.acmicpc.net/problem/17086

import java.util.*

val SHARK = 1
val BLANK = 0

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(n) { IntArray(m) }
val visit = Array(n) { BooleanArray(m) }
val q: Queue<Pair<Int,Int>> = LinkedList()
var result = 0

fun bfs() {
	val dx = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
	val dy = arrayOf(1, 0, -1, 1, -1, 1, 0, -1)

	while (q.isNotEmpty()) {
		val p = q.poll()

		for (i in 0 until 8) {
			val x = p.first + dx[i]
			val y = p.second + dy[i]

			if (x !in 0 until n || y !in 0 until m || visit[x][y]) continue
			map[x][y] = map[p.first][p.second] + 1
			q.offer(x to y)
			visit[x][y] = true
			if (result < map[x][y]) result = map[x][y]
		}
	}
}

fun main() {
	for (x in 0 until n) {
		token = StringTokenizer(reader.readLine())
		for (y in 0 until m) {
			if (token.nextToken().toInt() == SHARK) {
				q.offer(x to y)
				visit[x][y] = true
			}
		}
	}

	bfs()
	println(result)
}

main()
