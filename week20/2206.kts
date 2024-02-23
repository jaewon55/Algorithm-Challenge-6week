// https://www.acmicpc.net/problem/2206

import java.util.*

val SPACE = '0'
val WALL = '1'

val BROKE = 0
val NOT_BROKE = 1

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(n) { reader.readLine() }

fun bfs(): Int {
	val q: Queue<Position> = LinkedList()
	val visit = Array(n) {
		Array(m) { BooleanArray(2) }
	}
	val dx = arrayOf(1, -1, 0, 0)
	val dy = arrayOf(0, 0, 1, -1)
	var result = 1

	visit[0][0][NOT_BROKE] = true
	q.offer(Position(0, 0, false))

	while (q.isNotEmpty()) {
		++result
		repeat(q.size) {
			val p = q.poll()

			for (i in 0 until 4) {
				val x = p.x + dx[i]
				val y = p.y + dy[i]

				if (x == n - 1 && y == m - 1) return result

				if (x !in 0 until n || y !in 0 until m) continue
				if (p.isBroke && visit[x][y][BROKE]) continue
				if (!p.isBroke && visit[x][y][NOT_BROKE]) continue
				if (map[x][y] == WALL && p.isBroke) continue

				q.offer(Position(x, y, map[x][y] == WALL || p.isBroke))
				if (p.isBroke) {
					visit[x][y][BROKE] = true
				} else {
					visit[x][y][NOT_BROKE] = true
				}
			}
		}
	}
	return -1
}

fun main() {
	if (n == 1 && m == 1) {
		println(1)
	} else {
		println(bfs())
	}
}

data class Position(val x: Int, val y: Int, val isBroke: Boolean)

main()
