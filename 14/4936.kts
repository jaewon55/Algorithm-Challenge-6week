// https://www.acmicpc.net/problem/4963

import java.util.*

val map = Array(50) { BooleanArray(50) }
var w = 0
var h = 0
var count = 0

fun isOutOfMap(y: Int, x: Int) = y < 0 || h <= y || x < 0 || w <= x

fun bfs(y: Int, x: Int) {
	val q: Queue<Pair<Int, Int>> = LinkedList()
	val dy = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
	val dx = arrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

	q.offer(y to x)
	map[y][x] = false

	while (q.isNotEmpty()) {
		val p = q.poll()

		for (i in 0 until 8) {
			val ny = p.first + dy[i]
			val nx = p.second + dx[i]

			if (isOutOfMap(ny, nx) || !map[ny][nx]) continue
			q.offer(ny to nx)
			map[ny][nx] = false
		}
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token: StringTokenizer

	while (true) {
		token = StringTokenizer(reader.readLine())
		w = token.nextToken().toInt()
		h = token.nextToken().toInt()
		if (w == 0 && h == 0) break
		count = 0

		for (y in 0 until h) {
			token = StringTokenizer(reader.readLine())
			for (x in 0 until w) {
				map[y][x] = token.nextToken() == "1"
			}
		}

		for (y in 0 until h) {
			for (x in 0 until w) {
				if (map[y][x] == false) continue
				++count
				bfs(y, x)
			}
		}

		writer.write("$count\n")
	}
	writer.flush()
}

main()
