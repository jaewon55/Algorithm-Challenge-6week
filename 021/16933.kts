// https://www.acmicpc.net/problem/16933

import java.util.*

val WALL = '1'
val SPACE = '0'

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val k = token.nextToken().toInt()
val map = Array(n) { reader.readLine() }

fun bfs(): Int {
	val q: Queue<Position> = LinkedList()
	val visit = Array(n) { IntArray(m) { k + 1} }
	val dx = arrayOf(1, -1, 0, 0)
	val dy = arrayOf(0, 0 , 1, -1)
	var isDay = true
	var result = 2

	q.offer(Position(0, 0, 0))
	visit[0][0] = 0

	while (q.isNotEmpty()) {
		repeat(q.size) {
			val p = q.poll()

			for (i in 0 until 4) {
				val x = p.x + dx[i]
				val y = p.y + dy[i]

				if (x == n - 1 && y == m - 1) return result

				if (x !in 0 until n || y !in 0 until m) continue
				if (visit[x][y] <= p.k) continue
				if (map[x][y] == WALL && p.k == k) continue

				val newP = when {
					map[x][y] == WALL && !isDay -> p
					map[x][y] == WALL -> Position(x, y, p.k + 1)
					else -> Position(x, y, p.k)
				}
				q.offer(newP)
				if (newP.x != p.x || newP.y != p.y) visit[x][y] = p.k
			}
		}
		isDay = !isDay
		++result
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

data class Position(val x: Int, val y: Int, val k: Int)

main()
