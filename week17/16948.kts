// https://www.acmicpc.net/problem/16948

import java.util.*

fun bfs(start: Pair<Int,Int>, end: Pair<Int,Int>, n: Int) : Int {
	val dx = arrayOf(-2, -2, 0, 0, 2, 2)
	val dy = arrayOf(-1, 1, -2, 2, -1, 1)
	val visit = Array(n){ BooleanArray(n) }
	val q: Queue<Pair<Int,Int>> = LinkedList()
	var result = 0

	q.offer(start)
	visit[start.first][start.second] = true

	while (q.isNotEmpty()) {
		++result
		repeat(q.size) {
			val pos = q.poll()

			for (i in 0 until 6) {
				val x = pos.first + dx[i]
				val y = pos.second + dy[i]

				if (x == end.first && y == end.second) return result
				if (x !in 0 until n || y !in 0 until n || visit[x][y]) continue

				q.offer(x to y)
				visit[x][y] = true
			}
		}
	}
	return -1
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val start = token.nextToken().toInt() to token.nextToken().toInt()
	val end = token.nextToken().toInt() to token.nextToken().toInt()

	if (start == end) {
		println(0)
	} else {
		println(bfs(start, end, n))
	}
}

main()
