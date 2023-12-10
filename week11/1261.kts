// https://www.acmicpc.net/problem/1261

import java.util.*

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(m) {
	val line = reader.readLine()
	BooleanArray(n) { i -> line[i] == '0' }
}
val visit = Array(m) { BooleanArray(n) }
val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun isOutOfMap(x: Int, y: Int) = x !in 0 until n || y !in 0 until m

fun bfs(): Int {
	val q = PriorityQueue<State>()

	q.offer(State(0, 0, 0))
	visit[0][0] = true

	while (q.isNotEmpty()) {
		val state = q.poll()

		for (i in 0 until 4) {
			val x = state.x + dx[i]
			val y = state.y + dy[i]

			if (x == n - 1 && y == m - 1) return state.destroyCount
			if (isOutOfMap(x, y) || visit[y][x]) continue

			if (map[y][x]) {
				q.offer(State(x, y, state.destroyCount))
			} else {
				q.offer(State(x, y, state.destroyCount + 1))
			}
			visit[y][x] = true
		}
	}
	return 0
}

fun main() {
	println(bfs())
}

data class State(
	val x: Int,
	val y: Int,
	val destroyCount: Int,
) : Comparable<State> {
	override fun compareTo(other: State) = destroyCount - other.destroyCount
}

main()
